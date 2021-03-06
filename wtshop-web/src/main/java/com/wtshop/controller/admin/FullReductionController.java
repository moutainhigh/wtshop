package com.wtshop.controller.admin;

import com.jfinal.ext.route.ControllerBind;
import com.wtshop.Pageable;
import com.wtshop.model.*;
import com.wtshop.service.*;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

import static com.wtshop.controller.wap.BaseController.convertToLong;

/**
 * Controller - 促销
 * 
 * 
 */
@ControllerBind(controllerKey = "/admin/fullReduction")
public class FullReductionController extends BaseController {

	private FullReductionService promotionService = enhance(FullReductionService.class);
	private MemberRankService memberRankService = enhance(MemberRankService.class);
	private ProductService productService = enhance(ProductService.class);
	private CouponService couponService = enhance(CouponService.class);
	private GoodsService goodsService = enhance(GoodsService.class);

	/**
	 * 检查价格运算表达式是否正确
	 */
	public void checkPriceExpression() {
		String priceExpression = getPara("promotion.price_expression");
		if (StringUtils.isEmpty(priceExpression)) {
			renderJson(false);
			return;
		}
		renderJson(promotionService.isValidPriceExpression(priceExpression));
	}

	/**
	 * 检查积分运算表达式是否正确
	 */
	public void checkPointExpression() {
		String pointExpression = getPara("promotion.point_expression");
		if (StringUtils.isEmpty(pointExpression)) {
			renderJson(false);
			return;
		}
		renderJson(promotionService.isValidPointExpression(pointExpression));
	}

	/**
	 * 赠品选择
	 */
	public void giftSelect() {
		String keyword = getPara("q");
		Long[] excludeIds = getParaValuesToLong("excludeIds");
		Integer count = getParaToInt("limit");
		
		List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();
		if (StringUtils.isEmpty(keyword)) {
			renderJson(data);
			return;
		}
		Set<Product> excludes = new HashSet<Product>(productService.findList(excludeIds));
		List<Product> products = productService.search(Goods.Type.gift, keyword, excludes, count);
		for (Product product : products) {
			Map<String, Object> item = new HashMap<String, Object>();
			item.put("id", product.getId());
			item.put("sn", product.getSn());
			item.put("name", product.getName());
			item.put("specifications", product.getSpecifications());
			item.put("url", product.getUrl());
			data.add(item);
		}
		renderJson(data);
	}

	/**
	 * 添加
	 */
	public void add() {
		setAttr("memberRanks", memberRankService.findAll());
		setAttr("coupons", couponService.findAll());
		render("/admin/full_reduction/add.ftl");
	}

	/**
	 * 保存
	 */
	public void save() {
		FullReduction promotion = getModel(FullReduction.class);
		Long[] memberRankIds = getParaValuesToLong("memberRankIds");
		Long[] couponIds = getParaValuesToLong("couponIds");
		Long[] giftIds = getParaValuesToLong("giftIds");
		Boolean isFreeShipping = getParaToBoolean("isFreeShipping", false);
		Boolean isCouponAllowed = getParaToBoolean("isCouponAllowed", false);

		if (ArrayUtils.isNotEmpty(giftIds)) {
			List<Product> gifts = productService.findList(giftIds);
			CollectionUtils.filter(gifts, new Predicate() {
				public boolean evaluate(Object object) {
					Product gift = (Product) object;
					return gift != null && Goods.Type.gift.equals(gift.getType());
				}
			});

		} else {

		}
		
		if (promotion.getBeginDate() != null && promotion.getEndDate() != null && promotion.getBeginDate().after(promotion.getEndDate())) {
			redirect(ERROR_VIEW);
			return;
		}

		if (StringUtils.isNotEmpty(promotion.getPriceExpression()) && !promotionService.isValidPriceExpression(promotion.getPriceExpression())) {
			redirect(ERROR_VIEW);
			return;
		}
		if (StringUtils.isNotEmpty(promotion.getPointExpression()) && !promotionService.isValidPointExpression(promotion.getPointExpression())) {
			redirect(ERROR_VIEW);
			return;
		}

		promotionService.save(promotion);
		addFlashMessage(SUCCESS_MESSAGE);
		redirect("/admin/fullReduction/list.jhtml");
	}

	/**
	 * 编辑
	 */
	public void edit() {
		Long id = getParaToLong("id");
		setAttr("fullReduction", promotionService.find(id));
		render("/admin/full_reduction/edit.ftl");
	}

	/**
	 * 更新
	 */
	public void update() {
		FullReduction promotion = getModel(FullReduction.class);
		//Long[] memberRankIds = getParaValuesToLong("memberRankIds");
	//	Long[] couponIds = getParaValuesToLong("couponIds");
		Long[] giftIds = getParaValuesToLong("giftIds");
	//	Boolean isFreeShipping = getParaToBoolean("isFreeShipping", false);
	//	Boolean isCouponAllowed = getParaToBoolean("isCouponAllowed", false);
		

		if (ArrayUtils.isNotEmpty(giftIds)) {
			List<Product> gifts = productService.findList(giftIds);
			CollectionUtils.filter(gifts, new Predicate() {
				public boolean evaluate(Object object) {
					Product gift = (Product) object;
					return gift != null && Goods.Type.gift.equals(gift.getType());
				}
			});

		} else {

		}
		if (promotion.getBeginDate() != null && promotion.getEndDate() != null && promotion.getBeginDate().after(promotion.getEndDate())) {
			redirect(ERROR_VIEW);
			return;
		}

		if (StringUtils.isNotEmpty(promotion.getPriceExpression()) && !promotionService.isValidPriceExpression(promotion.getPriceExpression())) {
			redirect(ERROR_VIEW);
			return;
		}
		if (StringUtils.isNotEmpty(promotion.getPointExpression()) && !promotionService.isValidPointExpression(promotion.getPointExpression())) {
			redirect(ERROR_VIEW);
			return;
		}
		
		//promotion.remove("goods", "productCategories");
		promotionService.update(promotion);
		addFlashMessage(SUCCESS_MESSAGE);
		redirect("/admin/fullReduction/list.jhtml");
	}

	/**
	 * 列表
	 */
	public void list() {
		Pageable pageable = getBean(Pageable.class);
		setAttr("pageable", pageable);
		setAttr("page", promotionService.findPage(pageable));
		render("/admin/full_reduction/list.ftl");
	}

	/**
	 * 删除
	 */
	public void delete() {
		String[] values = StringUtils.split(getPara("ids"), ",");
		Long[] ids = values == null ? null :convertToLong(values);
		promotionService.delete(ids);
		renderJson(SUCCESS_MESSAGE);
	}

	/**
	 * 查看
	 */
	public void view(){
		Long id = getParaToLong("id");
		setAttr("promotion", goodsService.findGoodsByPromId(id));
		render("/admin/full_reduction/goodsList.ftl");
	}

}