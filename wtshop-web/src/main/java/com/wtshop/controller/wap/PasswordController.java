package com.wtshop.controller.wap;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;

import com.jfinal.aop.Before;
import com.jfinal.ext.route.ControllerBind;
import com.jfinal.i18n.I18n;
import com.jfinal.i18n.Res;
import com.wtshop.Setting;
import com.wtshop.entity.SafeKey;
import com.wtshop.interceptor.WapInterceptor;
import com.wtshop.model.Member;
import com.wtshop.model.Sms;
import com.wtshop.service.MailService;
import com.wtshop.service.MemberService;
import com.wtshop.service.SmsService;
import com.wtshop.util.SMSUtils;
import com.wtshop.util.SystemUtils;

/**
 * Controller - 密码
 * 
 * 
 */
@ControllerBind(controllerKey = "/wap/password")
@Before(WapInterceptor.class)
public class PasswordController extends BaseController {

	private MemberService memberService = enhance(MemberService.class);
	private MailService mailService = enhance(MailService.class);
	private SmsService smsService = enhance(SmsService.class);
	private Res resZh = I18n.use();
	
	/**
	 * 找回密码
	 */
	public void find() {
		setAttr("title" , "忘记密码");
		render("/wap/password/find.ftl");
	}
	
	/**
	 * 发送短信
	 */
	public void send_sms() {
		String mobile = getPara("mobile");
		String vcode = SMSUtils.randomSMSCode(4);
		
		Map<String, String> map = new HashMap<String, String>();
		if (StringUtils.isEmpty(mobile)) {
			map.put(STATUS, ERROR);
			map.put(MESSAGE, "手机号不能为空!");
			renderJson(map);
			return;
		}
		Member member = memberService.findByUsername(mobile);
		if (member == null) {
			map.put(STATUS, ERROR);
			map.put(MESSAGE, resZh.format("shop.password.memberNotExist"));
			renderJson(map);
			return;
		}
		Sms sms = new Sms();
		sms.setMobile(mobile);
		sms.setSmsCode(vcode);
		sms.setSmsType(Setting.SmsType.findPassword.ordinal());
		smsService.saveOrUpdate(sms);
		// 发送短信
		smsService.send(mobile, vcode);
		map.put(STATUS, SUCCESS);
		map.put(MESSAGE, "测试环境验证码是：" + vcode);
		renderJson(map);
	}
	
	/**
	 * 检查短信验证码
	 */
	public void reset_sms() {
		String mobile = getPara("mobile");
		String vcode = getPara("vcode");
		
		Map<String, String> map = new HashMap<String, String>();
		if (StringUtils.isEmpty(mobile) || StringUtils.isEmpty(vcode)) {
			map.put(STATUS, ERROR);
			map.put(MESSAGE, "手机或验证码不能为空!");
			renderJson(map);
			return;
		}
		if(!smsService.smsExists(mobile, vcode, Setting.SmsType.findPassword)) {
			map.put(STATUS, ERROR);
			map.put(MESSAGE, "手机验证码错误!");
			renderJson(map);
			return;
		} 
		Member member = memberService.findByUsername(mobile);
		if (member == null) {
			map.put(STATUS, ERROR);
			map.put(MESSAGE, resZh.format("shop.password.memberNotExist"));
			renderJson(map);
			return;
		}
		Setting setting = SystemUtils.getSetting();
		SafeKey safeKey = new SafeKey();
		safeKey.setValue(DigestUtils.md5Hex(UUID.randomUUID() + RandomStringUtils.randomAlphabetic(30)));
		safeKey.setExpire(setting.getSafeKeyExpiryTime() != 0 ? DateUtils.addMinutes(new Date(), setting.getSafeKeyExpiryTime()) : null);
		member.setSafeKeyExpire(safeKey.getExpire());
		member.setSafeKeyValue(safeKey.getValue());
		memberService.update(member);
		setAttr("title" , "修改密码");
		map.put(STATUS, SUCCESS);
		map.put("referer", "/wap/password/reset.jhtml?username=" + member.getUsername() + "&key=" + safeKey.getValue());
		renderJson(map);
	}
	
	/**
	 * 邮箱验证找回密码
	 */
	public void send_email() {
		String email = getPara("email");
		String username = getPara("username");
		
		Map<String, String> map = new HashMap<String, String>();
		if (StringUtils.isEmpty(email)) {
			map.put(STATUS, ERROR);
			map.put(MESSAGE, resZh.format("shop.common.invalid"));
			renderJson(map);
			return;
		}
		Member member = memberService.findByUsername(username);
		if (member == null) {
			map.put(STATUS, ERROR);
			map.put(MESSAGE, resZh.format("shop.password.memberNotExist"));
			renderJson(map);
			return;
		}
		if (StringUtils.isEmpty(member.getEmail())) {
			map.put(STATUS, ERROR);
			map.put(MESSAGE, resZh.format("shop.password.emailEmpty"));
			renderJson(map);
			return;
		}
		if (!StringUtils.equalsIgnoreCase(member.getEmail(), email)) {
			map.put(STATUS, ERROR);
			map.put(MESSAGE, resZh.format("shop.password.invalidEmail"));
			renderJson(map);
			return;
		}
		Setting setting = SystemUtils.getSetting();
		SafeKey safeKey = new SafeKey();
		safeKey.setValue(DigestUtils.md5Hex(UUID.randomUUID() + RandomStringUtils.randomAlphabetic(30)));
		safeKey.setExpire(setting.getSafeKeyExpiryTime() != 0 ? DateUtils.addMinutes(new Date(), setting.getSafeKeyExpiryTime()) : null);
		member.setSafeKeyExpire(safeKey.getExpire());
		member.setSafeKeyValue(safeKey.getValue());
		member.setSafeKey(safeKey);
		memberService.update(member);
		mailService.sendFindWapPasswordMail(member.getEmail(), member.getUsername(), safeKey);
		map.put(STATUS, SUCCESS);
		map.put("referer", "/wap/login/login.jhtml");
		renderJson(map);
	}
	
	
	/**
	 * 重置密码
	 */
	public void reset_email() {
		String username = getPara("username");
		String key = getPara("key");
		
		Map<String, String> map = new HashMap<String, String>();
		Member member = memberService.findByUsername(username);
		if (member == null) {
			map.put(STATUS, ERROR);
			map.put(MESSAGE, resZh.format("shop.password.memberNotExist"));
			renderJson(map);
			return;
		}
		SafeKey safeKey = new SafeKey();
		safeKey.setExpire(member.getSafeKeyExpire());
		safeKey.setValue(member.getSafeKeyValue());
		if (safeKey == null || safeKey.getValue() == null || !safeKey.getValue().equals(key)) {
			map.put(STATUS, ERROR);
			map.put(MESSAGE, "安全码错误!");
			renderJson(map);
			return;
		}
		if (safeKey.hasExpired()) {
			map.put(STATUS, ERROR);
			map.put(MESSAGE, resZh.format("shop.password.hasExpired"));
			renderJson(map);
			return;
		}
		setAttr("key", key);
		setAttr("username", member.getUsername());
		setAttr("title" , "修改密码");
		render("/wap/password/reset.ftl");
	}
	
	/**
	 * 重置密码提交
	 */
	public void submit() {
		String username = getPara("username");
		String newPassword = getPara("newPassword");
		String newPassword1 = getPara("newPassword1");
		String key = getPara("key");
		
		Map<String, String> map = new HashMap<String, String>();
		Member member = memberService.findByUsername(username);
		if (member == null) {
			map.put(STATUS, ERROR);
			map.put(MESSAGE, resZh.format("shop.password.memberNotExist"));
			renderJson(map);
			return;
		}
		if (!StringUtils.equals(newPassword, newPassword1)) {
			map.put(STATUS, ERROR);
			map.put(MESSAGE, "两次输入密码不相同!");
			renderJson(map);
			return;
		}
		Setting setting = SystemUtils.getSetting();
		if (newPassword.length() < setting.getPasswordMinLength() || newPassword.length() > setting.getPasswordMaxLength()) {
			map.put(STATUS, ERROR);
			map.put(MESSAGE, resZh.format("shop.password.invalidPassword"));
			renderJson(map);
			return;
		}
		SafeKey safeKey = new SafeKey();
		safeKey.setExpire(member.getSafeKeyExpire());
		safeKey.setValue(member.getSafeKeyValue());
		if (safeKey == null || safeKey.getValue() == null || !safeKey.getValue().equals(key)) {
			map.put(STATUS, ERROR);
			map.put(MESSAGE, "安全码错误!");
			renderJson(map);
			return;
		}
		if (safeKey.hasExpired()) {
			map.put(STATUS, ERROR);
			map.put(MESSAGE, resZh.format("shop.password.hasExpired"));
			renderJson(map);
			return;
		}
		member.setPassword(DigestUtils.md5Hex(newPassword));
		member.setSafeKeyExpire(null);
		member.setSafeKeyValue(null);
		memberService.update(member);
		map.put(STATUS, SUCCESS);
		renderJson(map);
	}
	
}
