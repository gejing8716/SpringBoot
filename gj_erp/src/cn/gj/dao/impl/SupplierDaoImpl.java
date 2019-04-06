package cn.gj.dao.impl;

import cn.gj.dao.SupplierDao;
import cn.gj.model.Supplier;
import cn.gj.query.SupplierQuery;

public class SupplierDaoImpl extends BaseDaoImpl<Supplier , SupplierQuery> implements SupplierDao {

	@Override
	public String creatHql(SupplierQuery q) {
		String hql = "from Supplier t where 1=1 ";
		
		return hql;
	}

	@Override
	public String creatHqlCount(SupplierQuery q) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public String creatHqlCondition(SupplierQuery q) {
		// TODO 自动生成的方法存根
		return null;
	}
}
