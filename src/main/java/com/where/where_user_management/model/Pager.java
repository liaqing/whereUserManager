package com.where.where_user_management.model;

import java.util.List;

public class Pager<E> {
	//当前页的记录
	private List<E> list;
	//当前页的页码
	private int pageNo;
	//分页大小
	private int pageSize;
	//总记录数
	private int totalNum;
	//总页数
	private int totalPage;
	
	
	public List<E> getList() {
		return list;
	}
	public void setList(List<E> list) {
		this.list = list;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalNum() {
		return totalNum;
	}
	public void setTotalNum(int totalNum) {
		this.totalNum = totalNum;
		setTotalPage((getTotalNum() % getPageSize()) == 0 ? (getTotalNum() / getPageSize()) : (getTotalNum()/getPageSize()+1));
		
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	
	/**
	 * 获取第一页
	 * @return
	 */
	public int getFirstPage(){
		return 1;
	}
	
	//获取最后一页
	public int getLastPage(){
		return totalPage;
	}
	
	//获取前页
	public int getPrePage(){
		if(pageNo>1){
			return pageNo-1;
		}
		return 1;
	}
	
	//获取后一页
	public int getBackPage(){
		if(pageNo<totalPage){
			return pageNo+1;
		}
		return totalPage;
	}
	
	//判断‘首页’及‘前页’是否可用
	public String isPreable(){
		if(pageNo == 1)
			return "disabled";
		return "";
	}
	
	//判断‘尾页’及‘下页’是否可用
	public String isBackable(){
		if(pageNo == totalPage)
			return "disabled";
		return "";
	}
	
}
