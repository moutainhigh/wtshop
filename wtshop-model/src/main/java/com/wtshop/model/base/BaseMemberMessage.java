package com.wtshop.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseMemberMessage<M extends BaseMemberMessage<M>> extends Model<M> implements IBean {

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

	public void setSound(Boolean sound) {
		set("sound", sound);
	}

	public Boolean getSound() {
		return get("sound");
	}

	public void setSystem(Boolean system) {
		set("system", system);
	}

	public Boolean getSystem() {
		return get("system");
	}

	public void setStaff(Boolean staff) {
		set("staff", staff);
	}

	public Boolean getStaff() {
		return get("staff");
	}

	public void setOrder(Boolean order) {
		set("order", order);
	}

	public Boolean getOrder() {
		return get("order");
	}

	public void setMemberId(Long memberId) {
		set("member_id", memberId);
	}

	public Long getMemberId() {
		return get("member_id");
	}

}
