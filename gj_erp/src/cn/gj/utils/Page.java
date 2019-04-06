package cn.gj.utils;

import java.util.List;

public class Page {
	
	/**
	 * 页码
	 */
	private Integer pageNo = 1;
	
	/**
	 * 每页的记录数
	 */
	private Integer pageSize = 5;
	
	/**
	 * 指定的查询条件下的总记录数，这个数据需要从后台数据库查询出来
	 */
	private Integer totalCount = 0;
	
	/**
	 * 指定查询条件下 的总页数
	 */
	private Integer totalPage = 1;
	
	/**
	 * 开始行号startNum = (pageNo - 1)*pageSize
	 */
	private Integer startNum = 0;
	
	
	/**
	 * 结果集必须通过数据库来查询
	 */
	private List<?> list;


	public Integer getPageNo() {
		return pageNo;
	}


	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}


	public Integer getPageSize() {
		return pageSize;
	}


	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}


	public Integer getTotalCount() {
		return totalCount;
	}


	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}


	/**
	 * pageSize		totalCount		totalPage
	 * 10				0				1
	 * 10				100				10
	 * 10				55				6
	 * 
	 * @return
	 */
	public Integer getTotalPage() {
		totalPage = totalCount/pageSize;
		if(totalCount == 0 || totalCount%pageSize != 0){
			totalPage++;
		}
		
		return totalPage;
	}


	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}


	/**
	 * 根据页码和每页记录数来计算开始行号
	 * @return
	 */
	public Integer getStartNum() {
		return (pageNo - 1)*pageSize;
	}


	public void setStartNum(Integer startNum) {
		this.startNum = startNum;
	}


	public List<?> getList() {
		return list;
	}


	public void setList(List<?> list) {
		this.list = list;
	}


	@Override
	public String toString() {
		return "Page [pageNo=" + pageNo + ", pageSize=" + pageSize + ", totalCount=" + totalCount + ", totalPage="
				+ totalPage + ", startNum=" + startNum + ", list=" + list + "]";
	}
	
	
	

}
