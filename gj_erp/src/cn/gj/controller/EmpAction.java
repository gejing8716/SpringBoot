package cn.gj.controller;

import java.io.IOException;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;

import cn.gj.model.Dep;
import cn.gj.model.Emp;
import cn.gj.query.EmpQuery;
import cn.gj.service.DepService;
import cn.gj.service.EmpService;
import cn.gj.utils.MD5Utils;
import cn.gj.utils.Page;

public class EmpAction extends BaseAction {
	
	private EmpQuery query = new EmpQuery();
	
	private Emp emp = new Emp();
	
	private EmpService empService;
	
	private DepService depService;
	
	public Emp getEmp() {
		return emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}

	public DepService getDepService() {
		return depService;
	}

	public void setDepService(DepService depService) {
		this.depService = depService;
	}

	public EmpQuery getQuery() {
		return query;
	}

	public void setQuery(EmpQuery query) {
		this.query = query;
	}

	public EmpService getEmpService() {
		return empService;
	}

	public void setEmpService(EmpService empService) {
		this.empService = empService;
	}

	public String emp_list() {
		List<Dep> list = depService.list();
		ActionContext context = ActionContext.getContext();
		context.put("dList", list);
		
		Integer pageNo = query.getPageNo();
		if(pageNo == null){
			query.setPageNo(1);
		}
		Page page = empService.queryObjByCondition(query, exclude);
		context.put("page", page);
		return SUCCESS;
	}

	public String emp_input() {
		List<Dep> list = depService.list();
		ActionContext context = ActionContext.getContext();
		context.put("dList", list);
		return SUCCESS;
	}
	public void ajax_emp_validUname() throws IOException{
		String result = "yes";
		Emp emp2 = empService.getEmpByUname(emp.getUsername());
		if(emp2.getUsername() != null){
			result = "no";
		}
		response.getWriter().print(result);
	}
	public void ajax_emp_add() throws IOException{
		String password = emp.getPassword();
		String md5 = MD5Utils.md5(password);
		emp.setPassword(md5);
		empService.save(emp);
		response.getWriter().print("success");
	}
	public String emp_update(){
		emp = empService.getObj(emp.getEmpId());
		List<Dep> list = depService.list();
		ActionContext context = ActionContext.getContext();
		context.put("dList", list);
		return SUCCESS;
	}
	public void ajax_emp_update() throws IOException{
		empService.updateEmp(emp);
		response.getWriter().print("success");
	}
	public String emp_delete(){
		empService.delete(emp);
		return LIST;
	}
}
