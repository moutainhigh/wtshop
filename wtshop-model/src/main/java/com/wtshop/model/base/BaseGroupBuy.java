package com.wtshop.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseGroupBuy<M extends BaseGroupBuy<M>> extends Model<M> implements IBean {

	public void setId(Long id) {
		set("id", id);
	}

	public Long getId() {
		return get("id");
	}

	public void setVersion(Long version) {
		set("version", version);
	}

	public Long getVersion() {
		return get("version");
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

	public void setOrders(Integer orders) {
		set("orders", orders);
	}

	public Integer getOrders() {
		return get("orders");
	}

	public void setTitle(String title) {
		set("title", title);
	}

	public String getTitle() {
		return get("title");
	}

	public void setPrice(Double price) {
		set("price", price);
	}

	public Double getPrice() {
		return get("price");
	}

	public void setUniprice(Double uniprice) {
		set("uniprice", uniprice);
	}

	public Double getUniprice() {
		return get("uniprice");
	}

	public void setNum(Integer num) {
		set("num", num);
	}

	public Integer getNum() {
		return get("num");
	}

	public void setStatus(Boolean status) {
		set("status", status);
	}

	public Boolean getStatus() {
		return get("status");
	}

	public void setRule(String rule) {
		set("rule", rule);
	}

	public String getRule() {
		return get("rule");
	}

	public void setExplain(String explain) {
		set("explain", explain);
	}

	public String getExplain() {
		return get("explain");
	}

	public void setProductId(Long productId) {
		set("product_id", productId);
	}

	public Long getProductId() {
		return get("product_id");
	}

	public void setCount(Integer count) {
		set("count", count);
	}

	public Integer getCount() {
		return get("count");
	}

	public void setSales(Integer sales) {
		set("sales", sales);
	}

	public Integer getSales() {
		return get("sales");
	}

	public void setTeamnum(Integer teamnum) {
		set("teamnum", teamnum);
	}

	public Integer getTeamnum() {
		return get("teamnum");
	}

	public void setDispatchprice(Double dispatchprice) {
		set("dispatchprice", dispatchprice);
	}

	public Double getDispatchprice() {
		return get("dispatchprice");
	}

	public void setGroupnum(Integer groupnum) {
		set("groupnum", groupnum);
	}

	public Integer getGroupnum() {
		return get("groupnum");
	}

	public void setIsList(Boolean isList) {
		set("is_list", isList);
	}

	public Boolean getIsList() {
		return get("is_list");
	}

	public void setIsTop(Boolean isTop) {
		set("is_top", isTop);
	}

	public Boolean getIsTop() {
		return get("is_top");
	}

	public void setIsSinglepurchase(Boolean isSinglepurchase) {
		set("is_singlepurchase", isSinglepurchase);
	}

	public Boolean getIsSinglepurchase() {
		return get("is_singlepurchase");
	}

	public void setBeginDate(java.util.Date beginDate) {
		set("begin_date", beginDate);
	}

	public java.util.Date getBeginDate() {
		return get("begin_date");
	}

	public void setEndDate(java.util.Date endDate) {
		set("end_date", endDate);
	}

	public java.util.Date getEndDate() {
		return get("end_date");
	}

	public void setGroupRate(Double groupRate) {
		set("group_rate", groupRate);
	}

	public Double getGroupRate() {
		return get("group_rate");
	}

}
