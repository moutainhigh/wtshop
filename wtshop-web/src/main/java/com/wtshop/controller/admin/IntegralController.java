package com.wtshop.controller.admin;

import com.jfinal.ext.route.ControllerBind;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.Record;
import com.wtshop.Message;
import com.wtshop.Pageable;
import com.wtshop.model.IntegralStore;
import com.wtshop.model.IntegralStoreLog;
import com.wtshop.model.Member;
import com.wtshop.service.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Controller - 积分
 * 
 * 
 */
@ControllerBind(controllerKey = "/admin/integral")
public class IntegralController extends BaseController {

	private PointLogService pointLogService = enhance(PointLogService.class);
	private MemberService memberService = enhance(MemberService.class);
	private MiaobiLogService miaobiLogService = enhance(MiaobiLogService.class);
	private IntegralLogService integralLogService=enhance(IntegralLogService.class);
	private IntegralStoreService integralStoreService=enhance(IntegralStoreService.class);
	private IntegralStoreLogService integralStoreLogService=enhance(IntegralStoreLogService.class);
	/**
	 * 检查会员
	 */
	public void checkMember() {
		String username = getPara("username");
		Map<String, Object> data = new HashMap<String, Object>();
		Member member = memberService.findByUsername(username);
		if (member == null) {
			data.put("message", Message.warn("admin.point.memberNotExist"));
			renderJson(data);
			return;
		}
		data.put("message", SUCCESS_MESSAGE);
		data.put("point", member.getPoint());
		renderJson(data);
	}

	/**
	 * 调整
	 */
	public void adjust() {
		render("/admin/integral/adjust.ftl");
	}



	/**
	 * 记录
	 */
	public void integralStoreList() {

		Pageable pageable = getBean(Pageable.class);
		Integer type = getParaToInt("typeName");
		Page<IntegralStore> pages = integralStoreService.findPages(pageable, type);

		setAttr("page", pages);
		setAttr("pageable", pageable);
		render("/admin/integral/integralStoreList.ftl");
	}

	/**
	 * 记录
	 */
	public void integralStoreLogList() {

		Pageable pageable = getBean(Pageable.class);
		Integer type = getParaToInt("typeName");
		Page<IntegralStoreLog> pages = integralStoreLogService.findPages(pageable, type);

		setAttr("page", pages);
		setAttr("pageable", pageable);
		render("/admin/integral/integralStoreLogList.ftl");
	}
	/**
	 * 记录
	 */
	public void list() {

		Pageable pageable = getBean(Pageable.class);
		Integer type = getParaToInt("typeName");
		Page<Record> pages = integralLogService.findPages(pageable, type);

		setAttr("page", pages);
		setAttr("pageable", pageable);
		render("/admin/integral/list.ftl");
	}
}