package com.wtshop.service;

import org.apache.commons.lang3.BooleanUtils;

import com.jfinal.aop.Enhancer;
import com.wtshop.dao.DeliveryCenterDao;
import com.wtshop.model.DeliveryCenter;
import com.wtshop.util.Assert;

/**
 * Service - 发货点
 * 
 * 
 */
public class DeliveryCenterService extends BaseService<DeliveryCenter> {

	/**
	 * 构造方法
	 */
	public DeliveryCenterService() {
		super(DeliveryCenter.class);
	}
	
	private DeliveryCenterDao deliveryCenterDao = Enhancer.enhance(DeliveryCenterDao.class);
	
	/**
	 * 查找默认发货点
	 * 
	 * @return 默认发货点，若不存在则返回null
	 */
	public DeliveryCenter findDefault() {
		return deliveryCenterDao.findDefault();
	}

	/**
	 * 保存
	 */
	public DeliveryCenter save(DeliveryCenter deliveryCenter) {
		Assert.notNull(deliveryCenter);

		if (BooleanUtils.isTrue(deliveryCenter.getIsDefault())) {
			deliveryCenterDao.setDefault(deliveryCenter);
		}
		String fullName = deliveryCenter.getArea().getFullName();
		deliveryCenter.setAreaName(fullName);
		return super.save(deliveryCenter);
	}

	/**
	 * 更新
	 */
	public DeliveryCenter update(DeliveryCenter deliveryCenter) {
		Assert.notNull(deliveryCenter);

		if (BooleanUtils.isTrue(deliveryCenter.getIsDefault())) {
			deliveryCenterDao.setDefault(deliveryCenter);
		}
		return super.update(deliveryCenter);
	}
}