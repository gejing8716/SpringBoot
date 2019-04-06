package cn.gj.query;

import cn.gj.model.Dep;

public class DepQuery extends Dep{

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
