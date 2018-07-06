package com.wtshop.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BasePromotionCoupon<M extends BasePromotionCoupon<M>> extends Model<M> implements IBean {

	public void setPromotions(Long promotions) {
		set("promotions", promotions);
	}

	public Long getPromotions() {
		return get("promotions");
	}

	public void setCoupons(Long coupons) {
		set("coupons", coupons);
	}

	public Long getCoupons() {
		return get("coupons");
	}

}
