package com.wtshop.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseMessageConfig<M extends BaseMessageConfig<M>> extends Model<M> implements IBean {

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

	public void setIsMailEnabled(Boolean isMailEnabled) {
		set("is_mail_enabled", isMailEnabled);
	}

	public Boolean getIsMailEnabled() {
		return get("is_mail_enabled");
	}

	public void setIsSmsEnabled(Boolean isSmsEnabled) {
		set("is_sms_enabled", isSmsEnabled);
	}

	public Boolean getIsSmsEnabled() {
		return get("is_sms_enabled");
	}

	public void setType(Integer type) {
		set("type", type);
	}

	public Integer getType() {
		return get("type");
	}

}
