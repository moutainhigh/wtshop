package com.wtshop.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseStockLog<M extends BaseStockLog<M>> extends Model<M> implements IBean {

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

	public void setInQuantity(Integer inQuantity) {
		set("in_quantity", inQuantity);
	}

	public Integer getInQuantity() {
		return get("in_quantity");
	}

	public void setMemo(String memo) {
		set("memo", memo);
	}

	public String getMemo() {
		return get("memo");
	}

	public void setOperator(String operator) {
		set("operator", operator);
	}

	public String getOperator() {
		return get("operator");
	}

	public void setOutQuantity(Integer outQuantity) {
		set("out_quantity", outQuantity);
	}

	public Integer getOutQuantity() {
		return get("out_quantity");
	}

	public void setStock(Integer stock) {
		set("stock", stock);
	}

	public Integer getStock() {
		return get("stock");
	}

	public void setType(Integer type) {
		set("type", type);
	}

	public Integer getType() {
		return get("type");
	}

	public void setProductId(Long productId) {
		set("product_id", productId);
	}

	public Long getProductId() {
		return get("product_id");
	}

}
