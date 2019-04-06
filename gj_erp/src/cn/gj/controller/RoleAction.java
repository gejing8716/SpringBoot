package cn.gj.controller;

import java.io.IOException;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;

import cn.gj.model.Dep;
import cn.gj.model.Emp;
import cn.gj.query.EmpQuery;
import cn.gj.service.DepService;
import cn.gj.service.EmpService;
import cn.gj.service.RoleService;
import cn.gj.utils.MD5Utils;
import cn.gj.utils.Page;

public class RoleAction extends BaseAction {
	
	RoleService roleService;
	
	public RoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	public String role_list(){
		return SUCCESS;
	}
}
