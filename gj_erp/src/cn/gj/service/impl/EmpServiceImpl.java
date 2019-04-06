package cn.gj.service.impl;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

import cn.gj.dao.EmpDao;
import cn.gj.model.Emp;
import cn.gj.query.EmpQuery;
import cn.gj.service.EmpService;

public class EmpServiceImpl extends BaseServiceImpl<Emp, EmpQuery> implements EmpService {

	
	private EmpDao empDao;
	
	public void setEmpDao(EmpDao empDao) {
		this.empDao = empDao;
		this.baseDao = empDao;
	}

	@Override
	public Emp getEmpByUname(String uername) {
		
		return empDao.getEmpByUname(uername);
	}

	@Override
	public void updateEmp(Emp emp) {
		Emp emp1 = empDao.getObj(emp.getEmpId());
		emp.setPassword(emp1.getPassword());
		try {
			BeanUtils.copyProperties(emp1, emp);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		empDao.update(emp1);
	}
}
