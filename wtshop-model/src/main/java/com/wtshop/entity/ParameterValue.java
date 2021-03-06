package com.wtshop.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Entity - 参数值
 * 
 * 
 */
public class ParameterValue implements Serializable {

	private static final long serialVersionUID = 1662250976814867003L;

	/** 参数组 */
	@JSONField(ordinal = 1)
	private String group;

	/** 条目 */
	@JSONField(ordinal = 2)
	private List<ParameterValue.Entry> entries = new ArrayList<ParameterValue.Entry>();

	/**
	 * 获取参数组
	 * 
	 * @return 参数组
	 */
	public String getGroup() {
		return group;
	}

	/**
	 * 设置参数组
	 * 
	 * @param group
	 *            参数组
	 */
	public void setGroup(String group) {
		this.group = group;
	}

	/**
	 * 获取条目
	 * 
	 * @return 条目
	 */
	public List<ParameterValue.Entry> getEntries() {
		return entries;
	}

	/**
	 * 设置条目
	 * 
	 * @param entries
	 *            条目
	 */
	public void setEntries(List<ParameterValue.Entry> entries) {
		this.entries = entries;
	}

	/**
	 * Entity - 条目
	 * 
	 * 
	 */
	public static class Entry implements Serializable {

		private static final long serialVersionUID = 6064272969056384535L;

		/** 名称 */
		@JSONField(ordinal = 1)
		private String name;

		/** 值 */
		@JSONField(ordinal = 2)
		private String value;

		/**
		 * 获取名称
		 * 
		 * @return 名称
		 */
		public String getName() {
			return name;
		}

		/**
		 * 设置名称
		 * 
		 * @param name
		 *            名称
		 */
		public void setName(String name) {
			this.name = name;
		}

		/**
		 * 获取值
		 * 
		 * @return 值
		 */
		public String getValue() {
			return value;
		}

		/**
		 * 设置值
		 * 
		 * @param value
		 *            值
		 */
		public void setValue(String value) {
			this.value = value;
		}

	}

}
