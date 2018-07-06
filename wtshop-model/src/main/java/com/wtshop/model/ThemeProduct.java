package com.wtshop.model;

import com.wtshop.model.base.BaseThemeProduct;
import com.wtshop.util.ObjectUtils;

/**
 * Generated by JFinal.
 */
@SuppressWarnings("serial")
public class ThemeProduct extends BaseThemeProduct<ThemeProduct> {
	public static final ThemeProduct dao = new ThemeProduct().dao();
	private Product product;

	public Product getProduct() {
		if(ObjectUtils.isEmpty(product)){
			product = Product.dao.findById(getProductId());
		}
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}


}
