package com.wtshop.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseReverseAuctionOrder<M extends BaseReverseAuctionOrder<M>> extends Model<M> implements IBean {

	public void setId(Long id) {
		set("id", id);
	}

	public Long getId() {
		return get("id");
	}

	public void setAuctionPayNo(String auctionPayNo) {
		set("auction_pay_no", auctionPayNo);
	}

	public String getAuctionPayNo() {
		return get("auction_pay_no");
	}

	public void setAuctionPayChannel(String auctionPayChannel) {
		set("auction_pay_channel", auctionPayChannel);
	}

	public String getAuctionPayChannel() {
		return get("auction_pay_channel");
	}

	public void setAuctionPayState(Integer auctionPayState) {
		set("auction_pay_state", auctionPayState);
	}

	public Integer getAuctionPayState() {
		return get("auction_pay_state");
	}

	public void setCallbackSummary(String callbackSummary) {
		set("callback_summary", callbackSummary);
	}

	public String getCallbackSummary() {
		return get("callback_summary");
	}

	public void setAuctionOtherNo(String auctionOtherNo) {
		set("auction_other_no", auctionOtherNo);
	}

	public String getAuctionOtherNo() {
		return get("auction_other_no");
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

	public void setCreateDate(java.util.Date createDate) {
		set("create_date", createDate);
	}

	public java.util.Date getCreateDate() {
		return get("create_date");
	}

}
