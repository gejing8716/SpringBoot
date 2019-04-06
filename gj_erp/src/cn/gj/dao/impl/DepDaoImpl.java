package cn.gj.dao.impl;

import org.apache.commons.lang.StringUtils;

import cn.gj.dao.DepDao;
import cn.gj.model.Dep;
import cn.gj.query.DepQuery;

public class DepDaoImpl extends BaseDaoImpl<Dep , DepQuery> implements DepDao {

	@Override
	public String creatHql(DepQuery q) {
		String hql = "from Dep t where 1=1 ";
		hql = hql + creatHqlCondition(q);
		return hql;
	}

	@Override
	public String creatHqlCount(DepQuery q) {
		String hql = "select count(depId) from Dep t where 1=1 ";
		hql = hql + creatHqlCondition(q);
		return hql;
	}

	@Override
	public String creatHqlCondition(DepQuery q) {
		String hql = "";
		if(StringUtils.isNotBlank(q.getName())){
			hql = hql + " and t.name like :name";
		}
		if(StringUtils.isNotBlank(q.getTel())){
			hql = hql + " and t.tel like :tel";
		}
		return hql;
	}
}
