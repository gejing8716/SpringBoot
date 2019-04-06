package cn.gj.query;

import java.util.Date;

import cn.gj.model.Emp;

public class EmpQuery extends Emp{
	
	private Integer startNum;
	
	private Integer pageNo;

	private Date startBirth;
	
	private Date endBirth;
	
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

	public Date getStartBirth() {
		return startBirth;
	}

	public void setStartBirth(Date startBirth) {
		this.startBirth = startBirth;
	}

	public Date getEndBirth() {
		return endBirth;
	}

	public void setEndBirth(Date endBirth) {
		this.endBirth = endBirth;
	}
	
	

}
