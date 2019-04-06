package cn.gj.service;

import cn.gj.model.Emp;
import cn.gj.query.EmpQuery;

public interface EmpService extends BaseService<Emp, EmpQuery> {
	
	public Emp getEmpByUname(String uername);
	
	public void updateEmp(Emp emp);

}
