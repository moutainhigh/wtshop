package com.wtshop.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseTag<M extends BaseTag<M>> extends Model<M> implements IBean {

	public void setId(Long id) {
		set("id", id);
	}

	public Long getId() {
		return get("id");
	}

	public void setCreateDate(java.util.Date createDate) {
		set("create_date", createDate);
	}

	public java.util.Date getCreateDate() {
		return get("create_date");
	}

	public void setModifyDate(java.util.Date modifyDate) {
		set("modify_date", modifyDate);
	}

	public java.util.Date getModifyDate() {
		return get("modify_date");
	}

	public void setVersion(Long version) {
		set("version", version);
	}

	public Long getVersion() {
		return get("version");
	}

	public void setOrders(Integer orders) {
		set("orders", orders);
	}

	public Integer getOrders() {
		return get("orders");
	}

	public void setIcon(String icon) {
		set("icon", icon);
	}

	public String getIcon() {
		return get("icon");
	}

	public void setMemo(String memo) {
		set("memo", memo);
	}

	public String getMemo() {
		return get("memo");
	}

	public void setName(String name) {
		set("name", name);
	}

	public String getName() {
		return get("name");
	}

	public void setType(Integer type) {
		set("type", type);
	}

	public Integer getType() {
		return get("type");
	}

}
