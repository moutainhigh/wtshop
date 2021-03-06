package com.wtshop.controller.wap.member;

import java.util.List;

import com.jfinal.aop.Before;
import com.jfinal.ext.route.ControllerBind;
import com.wtshop.Pageable;
import com.wtshop.controller.wap.BaseController;
import com.wtshop.interceptor.WapMemberInterceptor;
import com.wtshop.model.Member;
import com.wtshop.plugin.PaymentPlugin;
import com.wtshop.service.DepositLogService;
import com.wtshop.service.MemberService;
import com.wtshop.service.PluginService;

/**
 * Controller - 会员中心 - 预存款
 * 
 * 
 */
@ControllerBind(controllerKey = "/wap/member/deposit")
@Before(WapMemberInterceptor.class)
public class DepositController extends BaseController {

	/** 每页记录数 */
	private static final int PAGE_SIZE = 10;

	private MemberService memberService = enhance(MemberService.class);
	private DepositLogService depositLogService = enhance(DepositLogService.class);
	private PluginService pluginService = enhance(PluginService.class);
	
	/**
	 * 充值
	 */
	public void recharge() {
		List<PaymentPlugin> paymentPlugins = pluginService.getPaymentPlugins(true);
		if (!paymentPlugins.isEmpty()) {
			setAttr("defaultPaymentPlugin", paymentPlugins.get(0));
			setAttr("paymentPlugins", paymentPlugins);
		}
		setAttr("title" , "余额充值 - 会员中心");
		render("/wap/member/deposit/recharge.ftl");
	}
	
	/**
	 * 记录
	 */
	public void log() {
		Integer pageNumber = getParaToInt("pageNumber");
		Member member = memberService.getCurrent();
		Pageable pageable = new Pageable(pageNumber, PAGE_SIZE);
		setAttr("pages", depositLogService.findPage(member, pageable,1));
		setAttr("title" , "会员中心 - 预存款");
		render("/wap/member/deposit/log.ftl");
	}
	
	
}
