package com.wtshop.dao;

import com.wtshop.model.ShippingItem;

/**
 * Dao - 发货项
 * 
 * 
 */
public class ShippingItemDao extends BaseDao<ShippingItem> {
	
	/**
	 * 构造方法
	 */
	public ShippingItemDao() {
		super(ShippingItem.class);
	}
}