package cn.gj.dao.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import cn.gj.dao.EmpDao;
import cn.gj.model.Emp;
import cn.gj.query.EmpQuery;

public class EmpDaoImpl extends BaseDaoImpl<Emp , EmpQuery> implements EmpDao {

	@Override
	public String creatHql(EmpQuery q) {
		String hql = "from Emp t where 1=1 ";
		hql = hql + creatHqlCondition(q) + " order by t.empId desc";
		return hql;
	}

	@Override
	public String creatHqlCount(EmpQuery q) {
		String hql = "select count(empId) from Emp t where 1=1";
		hql = hql + creatHqlCondition(q);
		return hql;
	}

	@Override
	public String creatHqlCondition(EmpQuery q) {
		String hql = "";
		if(StringUtils.isNotBlank(q.getUsername())){
			hql = hql + " and t.username like :username";
		}
		if(StringUtils.isNotBlank(q.getName())){
			hql = hql + " and t.name like :name";
		}
		if(StringUtils.isNotBlank(q.getTel())){
			hql = hql + " and t.tel like :tel";
		}
		if(q.getGender() != null){
			hql = hql + " and t.gender = :gender";
		}
		
		if(StringUtils.isNotBlank(q.getEmail())){
			hql = hql + " and t.email like :email";
		}
		
		if(q.getStartBirth() != null){
			hql = hql + " and t.birthday >= :startBirth";
		}
		
		if(q.getEndBirth() != null){
			hql = hql + " and t.birthday <= :endBirth";
		}
		if(q.getDepId() != null){
			hql = hql + " and t.dep.depId = :depId";
		}
		return hql;
	}

	@Override
	public Emp getEmpByUname(String username) {
		Emp emp = new Emp();
		String hql = "from Emp e where e.username = ?";
		List<?> list = this.getHibernateTemplate().find(hql, username);
		if(list.size()>0){
			emp = (Emp) list.get(0);
		}
		return emp;
	}
}