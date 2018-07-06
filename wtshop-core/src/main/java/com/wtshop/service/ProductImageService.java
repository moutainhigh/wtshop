package com.wtshop.service;

import com.jfinal.core.JFinal;
import com.jfinal.upload.UploadFile;
import com.wtshop.FileType;
import com.wtshop.Setting;
import com.wtshop.entity.ProductImage;
import com.wtshop.plugin.StoragePlugin;
import com.wtshop.util.Assert;
import com.wtshop.util.FreeMarkerUtils;
import com.wtshop.util.ImageUtils;
import com.wtshop.util.SystemUtils;
import freemarker.template.TemplateException;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Service - 商品图片
 * 
 * 
 */
public class ProductImageService {

	/** 目标扩展名 */
	private static final String DEST_EXTENSION = "jpg";
	/** 目标文件类型 */
	private static final String DEST_CONTENT_TYPE = "image/jpeg";

	/** ServletContext */
	private ServletContext servletContext = JFinal.me().getServletContext();

	private int poolSize = 4;
	private ExecutorService executorService = Executors.newFixedThreadPool(poolSize);  
	
	private FileService fileService = new FileService();
	private PluginService pluginService = new PluginService();
	
	/**
	 * 添加图片处理任务
	 * 
	 * @param storagePlugin
	 *            存储插件
	 * @param sourcePath
	 *            原图片上传路径
	 * @param largePath
	 *            图片文件(大)上传路径
	 * @param mediumPath
	 *            图片文件(小)上传路径
	 * @param thumbnailPath
	 *            图片文件(缩略)上传路径
	 * @param tempFile
	 *            原临时文件
	 * @param contentType
	 *            原文件类型
	 */
	private void addTask(final StoragePlugin storagePlugin, final String sourcePath, final String largePath, final String mediumPath, final String thumbnailPath, final File tempFile, final String contentType) {
		executorService.execute(new Runnable() {
			@Override
			public void run() {
				Setting setting = SystemUtils.getSetting();
				File watermarkFile = new File(servletContext.getRealPath(setting.getWatermarkImage()));
				File largeTempFile = new File(FileUtils.getTempDirectory(), UUID.randomUUID() + "." + DEST_EXTENSION);
				File mediumTempFile = new File(FileUtils.getTempDirectory(), UUID.randomUUID() + "." + DEST_EXTENSION);
				File thumbnailTempFile = new File(FileUtils.getTempDirectory(), UUID.randomUUID() + "." + DEST_EXTENSION);
				try {
					ImageUtils.zoom(tempFile, largeTempFile, setting.getLargeProductImageWidth(), setting.getLargeProductImageHeight());
					ImageUtils.addWatermark(largeTempFile, largeTempFile, watermarkFile, setting.getWatermarkPosition(), setting.getWatermarkAlpha());
					ImageUtils.zoom(tempFile, mediumTempFile, setting.getMediumProductImageWidth(), setting.getMediumProductImageHeight());
					ImageUtils.addWatermark(mediumTempFile, mediumTempFile, watermarkFile, setting.getWatermarkPosition(), setting.getWatermarkAlpha());
					ImageUtils.zoom(tempFile, thumbnailTempFile, setting.getThumbnailProductImageWidth(), setting.getThumbnailProductImageHeight());
					storagePlugin.upload(sourcePath, tempFile, contentType);
					storagePlugin.upload(largePath, largeTempFile, DEST_CONTENT_TYPE);
					storagePlugin.upload(mediumPath, mediumTempFile, DEST_CONTENT_TYPE);
					storagePlugin.upload(thumbnailPath, thumbnailTempFile, DEST_CONTENT_TYPE);
				} finally {
					FileUtils.deleteQuietly(tempFile);
					FileUtils.deleteQuietly(largeTempFile);
					FileUtils.deleteQuietly(mediumTempFile);
					FileUtils.deleteQuietly(thumbnailTempFile);
				}
			}
		});
	}
	
	
	/**
	 * 商品图片过滤,排序
	 * 
	 * @param productImages
	 *            商品图片
	 */
	public void filter(List<ProductImage> productImages) {
		CollectionUtils.filter(productImages, new Predicate() {
			public boolean evaluate(Object object) {
				ProductImage productImage = (ProductImage) object;
				return productImage != null && !productImage.isEmpty() && isValid(productImage);
			}
		});

		Collections.sort(productImages, new Comparator<ProductImage>() {
			@Override
			public int compare(ProductImage o1, ProductImage o2) {
				if (o1.getOrders()!=null&&o2.getOrders()!=null){
					return   o1.getOrders()-o2.getOrders();
				}
				return 0;
			}
		});
	}
	

	/**
	 * 商品图片文件验证
	 * 
	 * @param productImage
	 *            商品图片
	 * @return 是否验证通过
	 */
	public boolean isValid(ProductImage productImage) {
		Assert.notNull(productImage);

		return productImage.getFile() == null || productImage.getFile().getFile().length() <= 0 || fileService.isValid(FileType.image, productImage.getFile());
	}

	/**
	 * 生成商品图片(异步)
	 * 
	 * @param productImage
	 *            商品图片
	 */
	public void generate(ProductImage productImage) {
		if (productImage == null || productImage.getFile() == null || productImage.getFile().getFile().length() <= 0) {
			return;
		}

		try {
			Setting setting = SystemUtils.getSetting();
			UploadFile uploadFile = productImage.getFile();
			Map<String, Object> model = new HashMap<String, Object>();
			model.put("uuid", UUID.randomUUID().toString());
			String uploadPath = FreeMarkerUtils.process(setting.getImageUploadPath(), model);
			String uuid = UUID.randomUUID().toString();
			String [] fileNameArr= new  String[4];
			fileNameArr[0]= uuid + "-source." + FilenameUtils.getExtension(uploadFile.getOriginalFileName());
			fileNameArr[1]= uuid + "-large." + DEST_EXTENSION;
			fileNameArr[2]= uuid + "-medium." + DEST_EXTENSION;
			fileNameArr[3]=  uuid + "-thumbnail." + DEST_EXTENSION;
			String sourcePath = uploadPath +fileNameArr[0];
			String largePath = uploadPath +fileNameArr[1];
			String mediumPath = uploadPath + fileNameArr[2];
			String thumbnailPath = uploadPath +  fileNameArr[3];
			for (StoragePlugin storagePlugin : pluginService.getStoragePlugins(true)) {
				File tempFile = new File(FileUtils.getTempDirectory(), UUID.randomUUID() + ".tmp");
				FileUtils.copyFile(uploadFile.getFile(), tempFile);
				addTask(storagePlugin, sourcePath, largePath, mediumPath, thumbnailPath, tempFile, uploadFile.getContentType());
				productImage.setSource(uploadPath+fileNameArr[0]);
				productImage.setLarge(uploadPath+fileNameArr[1]);
				productImage.setMedium(uploadPath+fileNameArr[2]);
				productImage.setThumbnail(uploadPath+fileNameArr[3]);
				break;
			}
		} catch (IllegalStateException e) {
			throw new RuntimeException(e.getMessage(), e);
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage(), e);
		} catch (TemplateException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	/**
	 * 生成商品图片(异步)
	 * 
	 * @param productImages
	 *            商品图片
	 */
	public void generate(List<ProductImage> productImages) {
		if (CollectionUtils.isEmpty(productImages)) {
			return;
		}
		for (ProductImage productImage : productImages) {
			generate(productImage);
		}
	}

}