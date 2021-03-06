package com.wtshop.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseTicketconfig<M extends BaseTicketconfig<M>> extends Model<M> implements IBean {

	public void setId(Long id) {
		set("id", id);
	}

	public Long getId() {
		return get("id");
	}

	public void setType(Integer type) {
		set("type", type);
	}

	public Integer getType() {
		return get("type");
	}

	public void setBeginTime(java.util.Date beginTime) {
		set("beginTime", beginTime);
	}

	public java.util.Date getBeginTime() {
		return get("beginTime");
	}

	public void setEndTime(java.util.Date endTime) {
		set("endTime", endTime);
	}

	public java.util.Date getEndTime() {
		return get("endTime");
	}

	public void setNum(Integer num) {
		set("num", num);
	}

	public Integer getNum() {
		return get("num");
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

	public void setState(Integer state) {
		set("state", state);
	}

	public Integer getState() {
		return get("state");
	}

	public void setMaxReceiveDay(Integer maxReceiveDay) {
		set("maxReceiveDay", maxReceiveDay);
	}

	public Integer getMaxReceiveDay() {
		return get("maxReceiveDay");
	}

	public void setShareLimit(Integer shareLimit) {
		set("shareLimit", shareLimit);
	}

	public Integer getShareLimit() {
		return get("shareLimit");
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
