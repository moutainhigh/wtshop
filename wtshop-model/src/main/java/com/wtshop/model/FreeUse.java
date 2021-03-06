package com.wtshop.model;

import com.wtshop.model.base.BaseFreeUse;
import com.wtshop.util.ObjectUtils;

/**
 * Generated by JFinal.
 */
@SuppressWarnings("serial")
public class FreeUse extends BaseFreeUse<FreeUse> {
	public static final FreeUse dao = new FreeUse().dao();
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
