package com.wtshop.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseHouserkeeperGrade<M extends BaseHouserkeeperGrade<M>> extends Model<M> implements IBean {

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

	public void setAmount(java.math.BigDecimal amount) {
		set("amount", amount);
	}

	public java.math.BigDecimal getAmount() {
		return get("amount");
	}

	public void setIsDefault(Boolean isDefault) {
		set("is_default", isDefault);
	}

	public Boolean getIsDefault() {
		return get("is_default");
	}

	public void setIsSpecial(Boolean isSpecial) {
		set("is_special", isSpecial);
	}

	public Boolean getIsSpecial() {
		return get("is_special");
	}

	public void setName(String name) {
		set("name", name);
	}

	public String getName() {
		return get("name");
	}

	public void setScale(Double scale) {
		set("scale", scale);
	}

	public Double getScale() {
		return get("scale");
	}

	public void setRule(String rule) {
		set("rule", rule);
	}

	public String getRule() {
		return get("rule");
	}

}
