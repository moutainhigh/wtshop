package com.wtshop.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseBargainHelp<M extends BaseBargainHelp<M>> extends Model<M> implements IBean {

	public void setId(Long id) {
		set("id", id);
	}

	public Long getId() {
		return get("id");
	}

	public void setBargainPersonalId(Integer bargainPersonalId) {
		set("bargain_personal_id", bargainPersonalId);
	}

	public Integer getBargainPersonalId() {
		return get("bargain_personal_id");
	}

	public void setPrice(Integer price) {
		set("price", price);
	}

	public Integer getPrice() {
		return get("price");
	}

	public void setCreatetime(Integer createtime) {
		set("createtime", createtime);
	}

	public Integer getCreatetime() {
		return get("createtime");
	}

}
