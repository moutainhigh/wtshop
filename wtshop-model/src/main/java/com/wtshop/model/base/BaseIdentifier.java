package com.wtshop.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseIdentifier<M extends BaseIdentifier<M>> extends Model<M> implements IBean {

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

	public void setTitle(String title) {
		set("title", title);
	}

	public String getTitle() {
		return get("title");
	}

	public void setStatus(Integer status) {
		set("status", status);
	}

	public Integer getStatus() {
		return get("status");
	}

	public void setCode(String code) {
		set("code", code);
	}

	public String getCode() {
		return get("code");
	}

	public void setOrders(Integer orders) {
		set("orders", orders);
	}

	public Integer getOrders() {
		return get("orders");
	}

	public void setEndDate(java.util.Date endDate) {
		set("end_date", endDate);
	}

	public java.util.Date getEndDate() {
		return get("end_date");
	}

	public void setShareCode(String shareCode) {
		set("share_code", shareCode);
	}

	public String getShareCode() {
		return get("share_code");
	}

	public void setPrice(java.math.BigDecimal price) {
		set("price", price);
	}

	public java.math.BigDecimal getPrice() {
		return get("price");
	}

	public void setMemberId(Long memberId) {
		set("member_id", memberId);
	}

	public Long getMemberId() {
		return get("member_id");
	}

	public void setStartDate(java.util.Date startDate) {
		set("start_date", startDate);
	}

	public java.util.Date getStartDate() {
		return get("start_date");
	}

	public void setTotalMoney(java.math.BigDecimal totalMoney) {
		set("total_money", totalMoney);
	}

	public java.math.BigDecimal getTotalMoney() {
		return get("total_money");
	}

	public void setMoney(java.math.BigDecimal money) {
		set("money", money);
	}

	public java.math.BigDecimal getMoney() {
		return get("money");
	}

	public void setCompleteDate(java.util.Date completeDate) {
		set("complete_date", completeDate);
	}

	public java.util.Date getCompleteDate() {
		return get("complete_date");
	}

	public void setIntegral(java.math.BigDecimal integral) {
		set("integral", integral);
	}

	public java.math.BigDecimal getIntegral() {
		return get("integral");
	}

}
