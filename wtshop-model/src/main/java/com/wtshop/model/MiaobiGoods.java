package com.wtshop.model;

import com.wtshop.model.base.BaseMiaobiGoods;
import com.wtshop.util.ObjectUtils;

/**
 * Generated by JFinal.
 */
@SuppressWarnings("serial")
public class MiaobiGoods extends BaseMiaobiGoods<MiaobiGoods> {
	public static final MiaobiGoods dao = new MiaobiGoods().dao();
	private Goods goods;
	//得到商品
	public Goods getGoods() {
		if(ObjectUtils.isEmpty(goods)){
			goods = Goods.dao.findById(getGoodsId());
		}
		return goods;
	}
}
