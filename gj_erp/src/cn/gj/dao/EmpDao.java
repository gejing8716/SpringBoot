package cn.gj.dao;

import cn.gj.model.Emp;
import cn.gj.query.EmpQuery;

public interface EmpDao extends BaseDao<Emp , EmpQuery>{
	
	public Emp getEmpByUname(String uername);

}
