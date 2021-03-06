package com.wtshop.model;

import com.wtshop.model.base.BaseOrgan;

/**
 * Generated by JFinal.
 */
@SuppressWarnings("serial")
public class Organ extends BaseOrgan<Organ> {
	public static final Organ dao = new Organ().dao();

	public enum Status {
		/** 店铺初始化 */
		init,

		/** 店铺已审核 */
		through,

		/** 店铺已发布 */
		using,

		/** 店铺已停用 */
		delete
	}

	public Status getStatusName() {
		return Status.values()[getStatus()];
	}

}
