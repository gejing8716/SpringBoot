package cn.gj.dao.impl;

import cn.gj.dao.RoleDao;
import cn.gj.model.Role;
import cn.gj.query.RoleQuery;

public class RoleDaoImpl extends BaseDaoImpl<Role , RoleQuery> implements RoleDao {

	@Override
	public String creatHql(RoleQuery q) {
		String hql = "from Role t where 1=1 ";
		
		return hql;
	}

	@Override
	public String creatHqlCount(RoleQuery q) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public String creatHqlCondition(RoleQuery q) {
		// TODO 自动生成的方法存根
		return null;
	}
}
