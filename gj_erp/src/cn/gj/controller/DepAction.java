package cn.gj.controller;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;

import cn.gj.model.Dep;
import cn.gj.query.DepQuery;
import cn.gj.service.DepService;
import cn.gj.utils.Page;

public class DepAction extends BaseAction {
	
	private DepQuery query = new DepQuery();
	
	private DepService depService;
	

	public DepQuery getQuery() {
		return query;
	}

	public DepService getDepService() {
		return depService;
	}

	public void setDepService(DepService depService) {
		this.depService = depService;
	}

	public void setQuery(DepQuery query) {
		this.query = query;
	}


	public String dep_list() {
		List<Dep> list = depService.list();
		ActionContext context = ActionContext.getContext();
		context.put("dList", list);
		
		Integer pageNo = query.getPageNo();
		if(pageNo == null){
			query.setPageNo(1);
		}
		Page page = depService.queryObjByCondition(query, exclude);
		context.put("page", page);
		return SUCCESS;
	}

	public String dep_input() {

		return SUCCESS;
	}
}
