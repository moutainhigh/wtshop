package com.wtshop.controller.admin;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;

import com.jfinal.ext.route.ControllerBind;
import com.wtshop.Setting;
import com.wtshop.service.CacheService;
import com.wtshop.util.SystemUtils;
import com.wtshop.util.WebUtils;

/**
 * Controller - 统计
 * 
 * 
 */
@ControllerBind(controllerKey = "/admin/statistics")
public class StatisticsController extends BaseController {

	private CacheService cacheService = new CacheService();

	/**
	 * 查看
	 */
	public void view() {
		Setting setting = SystemUtils.getSetting();
		setAttr("cnzzSiteId", setting.getCnzzSiteId());
		setAttr("cnzzPassword", setting.getCnzzPassword());
		render("/admin/statistics/view.ftl");
	}

	/**
	 * 设置
	 */
	public void setting() {
		Setting setting = SystemUtils.getSetting();
		setAttr("isCnzzEnabled", setting.getIsCnzzEnabled());
		render("/admin/statistics/setting.ftl");
	}

	/**
	 * 设置
	 */
	public void settingSubmit() {
		Boolean isEnabled = getParaToBoolean("isEnabled", false);
		Setting setting = SystemUtils.getSetting();
		if (isEnabled) {
			if (StringUtils.isEmpty(setting.getCnzzSiteId()) || StringUtils.isEmpty(setting.getCnzzPassword())) {
				String domain = setting.getSiteUrl().replaceAll("(^[\\s\\S]*?[^a-zA-Z0-9-.]+)|([^a-zA-Z0-9-.][\\s\\S]*$)", "");
				Map<String, Object> parameterMap = new HashMap<String, Object>();
				parameterMap.put("domain", domain);
				parameterMap.put("key", DigestUtils.md5Hex(domain + "Lfg4uP0H"));
				String content = WebUtils.get("http://intf.cnzz.com/user/companion/wtshop.php", parameterMap);
				if (StringUtils.contains(content, "@")) {
					setting.setCnzzSiteId(StringUtils.substringBefore(content, "@"));
					setting.setCnzzPassword(StringUtils.substringAfter(content, "@"));
				}
			}
		}
		setting.setIsCnzzEnabled(isEnabled);
		SystemUtils.setSetting(setting);
		cacheService.clear();
		addFlashMessage(SUCCESS_MESSAGE);
		redirect("setting.jhtml");
	}

}