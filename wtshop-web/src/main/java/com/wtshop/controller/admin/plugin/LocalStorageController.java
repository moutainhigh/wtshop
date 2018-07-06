package com.wtshop.controller.admin.plugin;

import com.jfinal.ext.route.ControllerBind;
import com.wtshop.controller.admin.BaseController;
import com.wtshop.model.PluginConfig;
import com.wtshop.plugin.localStorage.LocalStoragePlugin;
import com.wtshop.service.PluginConfigService;

/**
 * Controller - 本地文件存储
 * 
 * 
 */
@ControllerBind(controllerKey = "/admin/storage_plugin/local_storage")
public class LocalStorageController extends BaseController {

	private LocalStoragePlugin localStoragePlugin = new LocalStoragePlugin();
	private PluginConfigService pluginConfigService = enhance(PluginConfigService.class);

	/**
	 * 设置
	 */
	public void setting() {
		PluginConfig pluginConfig = localStoragePlugin.getPluginConfig();
		setAttr("pluginConfig", pluginConfig);
		render("/admin/plugin/localStorage/setting.ftl");
	}

	/**
	 * 更新
	 */
	public void update() {
		Integer order = getParaToInt("orders");
		PluginConfig pluginConfig = localStoragePlugin.getPluginConfig();
		pluginConfig.setIsEnabled(true);
		pluginConfig.setOrders(order);
		pluginConfigService.update(pluginConfig);
		addFlashMessage(SUCCESS_MESSAGE);
		redirect("/admin/storage_plugin/list.jhtml");
	}

}