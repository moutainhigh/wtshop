package com.wtshop.entity;

import java.io.Serializable;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.CompareToBuilder;

import com.alibaba.fastjson.annotation.JSONField;
import com.jfinal.upload.UploadFile;

/**
 * Entity - 商品图片
 * 
 * 
 */
public class ProductImage implements Serializable, Comparable<ProductImage> {

	private static final long serialVersionUID = -6959715318373332159L;

	/** 标题 */
	@JSONField(ordinal = 1)
	private String title;

	/** 原图片 */
	@JSONField(ordinal = 2)
	private String source;

	/** 大图片 */
	@JSONField(ordinal = 3)
	private String large;

	/** 中图片 */
	@JSONField(ordinal = 4)
	private String medium;

	/** 缩略图 */
	@JSONField(ordinal = 5)
	private String thumbnail;

	/** 排序 */
	@JSONField(ordinal = 6)
	private Integer orders;

	/** 文件 */
	@JSONField(serialize = false)
	private UploadFile file;

	/**
	 * 获取标题
	 * 
	 * @return 标题
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * 设置标题
	 * 
	 * @param title
	 *            标题
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * 获取原图片
	 * 
	 * @return 原图片
	 */
	public String getSource() {
		return source;
	}

	/**
	 * 设置原图片
	 * 
	 * @param source
	 *            原图片
	 */
	public void setSource(String source) {
		this.source = source;
	}

	/**
	 * 获取大图片
	 * 
	 * @return 大图片
	 */
	public String getLarge() {
		return large;
	}

	/**
	 * 设置大图片
	 * 
	 * @param large
	 *            大图片
	 */
	public void setLarge(String large) {
		this.large = large;
	}

	/**
	 * 获取中图片
	 * 
	 * @return 中图片
	 */
	public String getMedium() {
		return medium;
	}

	/**
	 * 设置中图片
	 * 
	 * @param medium
	 *            中图片
	 */
	public void setMedium(String medium) {
		this.medium = medium;
	}

	/**
	 * 获取缩略图
	 * 
	 * @return 缩略图
	 */
	public String getThumbnail() {
		return thumbnail;
	}

	/**
	 * 设置缩略图
	 * 
	 * @param thumbnail
	 *            缩略图
	 */
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	/**
	 * 获取排序
	 * 
	 * @return 排序
	 */
	public Integer getOrders() {
		return orders;
	}

	/**
	 * 设置排序
	 * 
	 * @param order
	 *            排序
	 */
	public void setOrders(Integer orders) {
		this.orders = orders;
	}

	/**
	 * 获取文件
	 * 
	 * @return 文件
	 */
	public UploadFile getFile() {
		return file;
	}

	/**
	 * 设置文件
	 * 
	 * @param file
	 *            文件
	 */
	public void setFile(UploadFile file) {
		this.file = file;
	}

	/**
	 * 判断是否为空
	 * 
	 * @return 是否为空
	 */
	@JSONField(serialize = false)
	public boolean isEmpty() {
		return (getFile() == null || getFile().getFile().length() <= 0) && (StringUtils.isEmpty(getSource()) || StringUtils.isEmpty(getLarge()) || StringUtils.isEmpty(getMedium()) || StringUtils.isEmpty(getThumbnail()));
	}

	/**
	 * 实现compareTo方法
	 * 
	 * @param productImage
	 *            商品图片
	 * @return 比较结果
	 */
	@JSONField(serialize = false)
	public int compareTo(ProductImage productImage) {
		if (productImage == null) {
			return 1;
		}
		return new CompareToBuilder().append(getOrders(), productImage.getOrders()).toComparison();
	}

}
