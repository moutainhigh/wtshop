package com.wtshop.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BasePermissionRole<M extends BasePermissionRole<M>> extends Model<M> implements IBean {

	public void setPermissions(Long permissions) {
		set("permissions", permissions);
	}

	public Long getPermissions() {
		return get("permissions");
	}

	public void setRoles(Long roles) {
		set("roles", roles);
	}

	public Long getRoles() {
		return get("roles");
	}

}
