package com.wtshop.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseProductCategoryPromotion<M extends BaseProductCategoryPromotion<M>> extends Model<M> implements IBean {

	public void setProductCategories(Long productCategories) {
		set("product_categories", productCategories);
	}

	public Long getProductCategories() {
		return get("product_categories");
	}

	public void setPromotions(Long promotions) {
		set("promotions", promotions);
	}

	public Long getPromotions() {
		return get("promotions");
	}

}
