package cn.gj.service.impl;

import cn.gj.dao.RoleDao;
import cn.gj.model.Role;
import cn.gj.query.RoleQuery;
import cn.gj.service.RoleService;

public class RoleServiceImpl extends BaseServiceImpl<Role, RoleQuery> implements RoleService {

	
	private RoleDao roleDao;
	
	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
		this.baseDao = roleDao;
	}
}
