package com.wtshop.model;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseFudaiProduct<M extends BaseFudaiProduct<M>> extends Model<M> implements IBean {

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

	public void setFudaiId(Long fudaiId) {
		set("fudai_id", fudaiId);
	}

	public Long getFudaiId() {
		return get("fudai_id");
	}

	public void setProductId(Long productId) {
		set("product_id", productId);
	}

	public Long getProductId() {
		return get("product_id");
	}

	public void setIsMain(Integer isMain) {
		set("is_main", isMain);
	}

	public Integer getIsMain() {
		return get("is_main");
	}

	public void setProbability(Double probability) {
		set("probability", probability);
	}

	public Double getProbability() {
		return get("probability");
	}

	public void setRepeatTime(Long repeatTime) {
		set("repeatTime", repeatTime);
	}

	public Long getRepeatTime() {
		return get("repeatTime");
	}

	public void setGrandPrix(Integer grandPrix) {
		set("grandPrix", grandPrix);
	}

	public Integer getGrandPrix() {
		return get("grandPrix");
	}

	public void setMaxNum(Integer maxNum) {
		set("maxNum", maxNum);
	}

	public Integer getMaxNum() {
		return get("maxNum");
	}

}
