package cn.gj.query;

import cn.gj.model.Role;

public class RoleQuery extends Role{

	private Integer startNum;
	
	private Integer pageNo;
	
	public Integer getStartNum() {
		return startNum;
	}

	public void setStartNum(Integer startNum) {
		this.startNum = startNum;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}
}
