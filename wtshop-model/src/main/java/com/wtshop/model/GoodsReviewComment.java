package com.wtshop.model;

import com.wtshop.model.base.BaseGoodsReviewComment;

/**
 * Generated by JFinal.
 */
@SuppressWarnings("serial")
public class GoodsReviewComment extends BaseGoodsReviewComment<GoodsReviewComment> {
	public static final GoodsReviewComment dao = new GoodsReviewComment().dao();

	private Admin admin = null;

	public Admin getAdmin(){
		if (admin == null){
			admin = Admin.dao.findFirst("select * from admin where id = " + getAdminId());
		}
		return admin;
	}

}
