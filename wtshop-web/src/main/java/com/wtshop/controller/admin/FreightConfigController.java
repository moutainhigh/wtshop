package com.wtshop.controller.admin;

import com.jfinal.ext.route.ControllerBind;
import com.wtshop.Pageable;
import com.wtshop.model.Area;
import com.wtshop.model.FreightConfig;
import com.wtshop.model.ShippingMethod;
import com.wtshop.service.AreaService;
import com.wtshop.service.FreightConfigService;
import com.wtshop.service.ShippingMethodService;

/**
 * Controller - 运费配置
 * 
 * 
 */
@ControllerBind(controllerKey = "/admin/freight_config")
public class FreightConfigController extends BaseController {

	private FreightConfigService freightConfigService = enhance(FreightConfigService.class);
	private ShippingMethodService shippingMethodService = enhance(ShippingMethodService.class);
	private AreaService areaService = enhance(AreaService.class);

	/**
	 * 检查地区是否唯一
	 */
	public void checkArea() {
		Long shippingMethodId = getParaToLong("shippingMethodId");
		Long previousAreaId = getParaToLong("previousAreaId");
		Long areaId = getParaToLong("areaId");
		if (areaId == null) {
			renderJson(false);
			return;
		}
		ShippingMethod shippingMethod = shippingMethodService.find(shippingMethodId);
		Area previousArea = areaService.find(previousAreaId);
		Area area = areaService.find(areaId);
		renderJson(freightConfigService.unique(shippingMethod, previousArea, area));
	}

	/**
	 * 添加
	 */
	public void add() {
		Long shippingMethodId = getParaToLong("shippingMethodId");
		setAttr("shippingMethod", shippingMethodService.find(shippingMethodId));
		render("/admin/freight_config/add.ftl");
	}

	/**
	 * 保存
	 */
	public void save() {
		FreightConfig freightConfig = getModel(FreightConfig.class);
		Long shippingMethodId = getParaToLong("shippingMethodId");
		Long areaId = getParaToLong("areaId");
		Area area = areaService.find(areaId);
		ShippingMethod shippingMethod = shippingMethodService.find(shippingMethodId);
		freightConfig.setArea(area);
		freightConfig.setShippingMethod(shippingMethod);
		freightConfig.setAreaId(areaId);
		freightConfig.setShippingMethodId(shippingMethodId);
		if (freightConfigService.exists(shippingMethod, area)) {
			redirect(ERROR_VIEW);
			return;
		}
		freightConfigService.save(freightConfig);
		addFlashMessage(SUCCESS_MESSAGE);
		redirect("list.jhtml");
	}

	/**
	 * 编辑
	 */
	public void edit() {
		Long id = getParaToLong("id");
		setAttr("freightConfig", freightConfigService.find(id));
		render("/admin/freight_config/edit.ftl");
	}

	/**
	 * 更新
	 */
	public void update() {
		FreightConfig freightConfig = getModel(FreightConfig.class);
		Long id = getParaToLong("id");
		Long areaId = getParaToLong("areaId");

		Area area = areaService.find(areaId);
		freightConfig.setArea(area);
		freightConfig.setAreaId(areaId);
		FreightConfig pFreightConfig = freightConfigService.find(freightConfig.getId());
		if (!freightConfigService.unique(pFreightConfig.getShippingMethod(), pFreightConfig.getArea(), area)) {
			redirect(ERROR_VIEW);
			return;
		}
		freightConfig.remove("shippingMethod");
		freightConfigService.update(freightConfig);
		addFlashMessage(SUCCESS_MESSAGE);
		redirect("list.jhtml");
	}

	/**
	 * 列表
	 */
	public void list() {
		Pageable pageable = getBean(Pageable.class);
		Long shippingMethodId = getParaToLong("shippingMethodId");
		ShippingMethod shippingMethod = shippingMethodService.find(shippingMethodId);
		setAttr("shippingMethod", shippingMethod);
		setAttr("page", freightConfigService.findPage(shippingMethod, pageable));
		render("/admin/freight_config/list.ftl");
	}

	/**
	 * 删除
	 */
	public void delete() {
		Long[] ids = getParaValuesToLong("ids");
		freightConfigService.delete(ids);
		renderJson(SUCCESS_MESSAGE);
	}

}