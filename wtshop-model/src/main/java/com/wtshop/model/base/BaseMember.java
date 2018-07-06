package com.wtshop.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseMember<M extends BaseMember<M>> extends Model<M> implements IBean {

	public void setId(Long id) {
		set("id", id);
	}

	public Long getId() {
		return get("id");
	}

	public void setCreateDate(java.util.Date createDate) {
		set("create_date", createDate);
	}

	public java.util.Date getCreateDate() {
		return get("create_date");
	}

	public void setModifyDate(java.util.Date modifyDate) {
		set("modify_date", modifyDate);
	}

	public java.util.Date getModifyDate() {
		return get("modify_date");
	}

	public void setVersion(Long version) {
		set("version", version);
	}

	public Long getVersion() {
		return get("version");
	}

	public void setAddress(String address) {
		set("address", address);
	}

	public String getAddress() {
		return get("address");
	}

	public void setAmount(java.math.BigDecimal amount) {
		set("amount", amount);
	}

	public java.math.BigDecimal getAmount() {
		return get("amount");
	}

	public void setAttributeValue0(String attributeValue0) {
		set("attribute_value0", attributeValue0);
	}

	public String getAttributeValue0() {
		return get("attribute_value0");
	}

	public void setAttributeValue1(String attributeValue1) {
		set("attribute_value1", attributeValue1);
	}

	public String getAttributeValue1() {
		return get("attribute_value1");
	}

	public void setAttributeValue2(String attributeValue2) {
		set("attribute_value2", attributeValue2);
	}

	public String getAttributeValue2() {
		return get("attribute_value2");
	}

	public void setAttributeValue3(String attributeValue3) {
		set("attribute_value3", attributeValue3);
	}

	public String getAttributeValue3() {
		return get("attribute_value3");
	}

	public void setAttributeValue4(String attributeValue4) {
		set("attribute_value4", attributeValue4);
	}

	public String getAttributeValue4() {
		return get("attribute_value4");
	}

	public void setAttributeValue5(String attributeValue5) {
		set("attribute_value5", attributeValue5);
	}

	public String getAttributeValue5() {
		return get("attribute_value5");
	}

	public void setAttributeValue6(String attributeValue6) {
		set("attribute_value6", attributeValue6);
	}

	public String getAttributeValue6() {
		return get("attribute_value6");
	}

	public void setAttributeValue7(String attributeValue7) {
		set("attribute_value7", attributeValue7);
	}

	public String getAttributeValue7() {
		return get("attribute_value7");
	}

	public void setAttributeValue8(String attributeValue8) {
		set("attribute_value8", attributeValue8);
	}

	public String getAttributeValue8() {
		return get("attribute_value8");
	}

	public void setAttributeValue9(String attributeValue9) {
		set("attribute_value9", attributeValue9);
	}

	public String getAttributeValue9() {
		return get("attribute_value9");
	}

	public void setBalance(java.math.BigDecimal balance) {
		set("balance", balance);
	}

	public java.math.BigDecimal getBalance() {
		return get("balance");
	}

	public void setRecharge(java.math.BigDecimal recharge) {
		set("recharge", recharge);
	}

	public java.math.BigDecimal getRecharge() {
		return get("recharge");
	}

	public void setPrestore(java.math.BigDecimal prestore) {
		set("prestore", prestore);
	}

	public java.math.BigDecimal getPrestore() {
		return get("prestore");
	}

	public void setCommission(java.math.BigDecimal commission) {
		set("commission", commission);
	}

	public java.math.BigDecimal getCommission() {
		return get("commission");
	}

	public void setPayPassword(String payPassword) {
		set("pay_password", payPassword);
	}

	public String getPayPassword() {
		return get("pay_password");
	}

	public void setBirth(java.util.Date birth) {
		set("birth", birth);
	}

	public java.util.Date getBirth() {
		return get("birth");
	}

	public void setEmail(String email) {
		set("email", email);
	}

	public String getEmail() {
		return get("email");
	}

	public void setGender(Integer gender) {
		set("gender", gender);
	}

	public Integer getGender() {
		return get("gender");
	}

	public void setIsEnabled(Boolean isEnabled) {
		set("is_enabled", isEnabled);
	}

	public Boolean getIsEnabled() {
		return get("is_enabled");
	}

	public void setIsLocked(Boolean isLocked) {
		set("is_locked", isLocked);
	}

	public Boolean getIsLocked() {
		return get("is_locked");
	}

	public void setLockKey(String lockKey) {
		set("lock_key", lockKey);
	}

	public String getLockKey() {
		return get("lock_key");
	}

	public void setLockedDate(java.util.Date lockedDate) {
		set("locked_date", lockedDate);
	}

	public java.util.Date getLockedDate() {
		return get("locked_date");
	}

	public void setLoginDate(java.util.Date loginDate) {
		set("login_date", loginDate);
	}

	public java.util.Date getLoginDate() {
		return get("login_date");
	}

	public void setLoginFailureCount(Integer loginFailureCount) {
		set("login_failure_count", loginFailureCount);
	}

	public Integer getLoginFailureCount() {
		return get("login_failure_count");
	}

	public void setLoginIp(String loginIp) {
		set("login_ip", loginIp);
	}

	public String getLoginIp() {
		return get("login_ip");
	}

	public void setLoginPluginId(String loginPluginId) {
		set("login_plugin_id", loginPluginId);
	}

	public String getLoginPluginId() {
		return get("login_plugin_id");
	}

	public void setMobile(String mobile) {
		set("mobile", mobile);
	}

	public String getMobile() {
		return get("mobile");
	}

	public void setName(String name) {
		set("name", name);
	}

	public String getName() {
		return get("name");
	}

	public void setNickname(String nickname) {
		set("nickname", nickname);
	}

	public String getNickname() {
		return get("nickname");
	}

	public void setOpenId(String openId) {
		set("open_id", openId);
	}

	public String getOpenId() {
		return get("open_id");
	}

	public void setPassword(String password) {
		set("password", password);
	}

	public String getPassword() {
		return get("password");
	}

	public void setPhone(String phone) {
		set("phone", phone);
	}

	public String getPhone() {
		return get("phone");
	}

	public void setSign(String sign) {
		set("sign", sign);
	}

	public String getSign() {
		return get("sign");
	}

	public void setPoint(java.math.BigDecimal point) {
		set("point", point);
	}

	public java.math.BigDecimal getPoint() {
		return get("point");
	}

	public void setRegisterIp(String registerIp) {
		set("register_ip", registerIp);
	}

	public String getRegisterIp() {
		return get("register_ip");
	}

	public void setSafeKeyExpire(java.util.Date safeKeyExpire) {
		set("safe_key_expire", safeKeyExpire);
	}

	public java.util.Date getSafeKeyExpire() {
		return get("safe_key_expire");
	}

	public void setSafeKeyValue(String safeKeyValue) {
		set("safe_key_value", safeKeyValue);
	}

	public String getSafeKeyValue() {
		return get("safe_key_value");
	}

	public void setAvatar(String avatar) {
		set("avatar", avatar);
	}

	public String getAvatar() {
		return get("avatar");
	}

	public void setUsername(String username) {
		set("username", username);
	}

	public String getUsername() {
		return get("username");
	}

	public void setZipCode(String zipCode) {
		set("zip_code", zipCode);
	}

	public String getZipCode() {
		return get("zip_code");
	}

	public void setAreaId(Long areaId) {
		set("area_id", areaId);
	}

	public Long getAreaId() {
		return get("area_id");
	}

	public void setIsVip(Boolean isVip) {
		set("is_vip", isVip);
	}

	public Boolean getIsVip() {
		return get("is_vip");
	}

	public void setMemberRankId(Long memberRankId) {
		set("member_rank_id", memberRankId);
	}

	public Long getMemberRankId() {
		return get("member_rank_id");
	}

	public void setIsDelete(Boolean isDelete) {
		set("is_delete", isDelete);
	}

	public Boolean getIsDelete() {
		return get("is_delete");
	}


	public void setRegisterType(Integer registerType) {
		set("register_type", registerType);
	}

	public Integer getRegisterType() {
		return get("register_type");
	}

}
