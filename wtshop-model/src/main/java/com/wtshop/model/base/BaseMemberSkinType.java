package com.wtshop.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseMemberSkinType<M extends BaseMemberSkinType<M>> extends Model<M> implements IBean {

	public void setMembers(Long members) {
		set("members", members);
	}

	public Long getMembers() {
		return get("members");
	}

	public void setSkinType(Long skinType) {
		set("skin_type", skinType);
	}

	public Long getSkinType() {
		return get("skin_type");
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

}
