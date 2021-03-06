package com.wtshop.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseCouponShare<M extends BaseCouponShare<M>> extends Model<M> implements IBean {

	public void setId(Long id) {
		set("id", id);
	}

	public Long getId() {
		return get("id");
	}

	public void setCouponId(Long couponId) {
		set("couponId", couponId);
	}

	public Long getCouponId() {
		return get("couponId");
	}

	public void setTitle(String title) {
		set("title", title);
	}

	public String getTitle() {
		return get("title");
	}

	public void setContent(String content) {
		set("content", content);
	}

	public String getContent() {
		return get("content");
	}

	public void setLink(String link) {
		set("link", link);
	}

	public String getLink() {
		return get("link");
	}

	public void setNumLimit(Integer numLimit) {
		set("numLimit", numLimit);
	}

	public Integer getNumLimit() {
		return get("numLimit");
	}

	public void setCurrentNum(Integer currentNum) {
		set("currentNum", currentNum);
	}

	public Integer getCurrentNum() {
		return get("currentNum");
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

	public void setState(Integer state) {
		set("state", state);
	}

	public Integer getState() {
		return get("state");
	}

}
