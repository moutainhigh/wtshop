package com.wtshop.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BasePromotionMemberRank<M extends BasePromotionMemberRank<M>> extends Model<M> implements IBean {

	public void setPromotions(Long promotions) {
		set("promotions", promotions);
	}

	public Long getPromotions() {
		return get("promotions");
	}

	public void setMemberRanks(Long memberRanks) {
		set("member_ranks", memberRanks);
	}

	public Long getMemberRanks() {
		return get("member_ranks");
	}

}
