package com.wtshop.model;

import com.wtshop.model.base.BaseInformation;
import com.wtshop.util.ObjectUtils;

/**
 * Generated by JFinal.
 */
@SuppressWarnings("serial")
public class Information extends BaseInformation<Information> {
	public static final Information dao = new Information().dao();


	/**
	 * 消息动作
	 */
	public enum Action {

		/** 无动作 */
		none,

		/** 订单 */
		order,

		/** 商品 */
		goods,

		/** 站内链接 */
		inLink,

		/** 站外链接 */
		outLink

	}

	/**
	 * 订单类型
	 * 0 - 3 属于我的消息 4属于技师消息
	 */
	public enum Type {

		/** 系统消息 */
		none,

		/** 订单消息 */
		order,

		/** 新闻消息 */
		news,

		/** 我的关注到货提醒消息 */
		myFavorite,

		/** 技师消息 */
		staff
	}

	private Member member;

	/**
	 * 获取会员
	 *
	 * @return 会员
	 */
	public Member getMember() {
		if (ObjectUtils.isEmpty(member)) {
			member = Member.dao.findById(getMemberId());
		}
		return member;
	}

	/**
	 * 设置会员
	 *
	 * @param member
	 *            会员
	 */
	public void setMember(Member member) {
		this.member = member;
	}




}
