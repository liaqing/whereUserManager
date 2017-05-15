package com.where.where_user_management.model;

public class SystemContext {
	//分页大小
	private static ThreadLocal<Integer> pageSize =new ThreadLocal<Integer>();
	//分页的页码
	private static ThreadLocal<Integer> pageNo=new ThreadLocal<Integer>();
	//列表的排序字段
	private static ThreadLocal<String> sort;
	//列表的排序方式
	private static ThreadLocal<String> order;
	
	
	public static Integer getPageSize() {
		return pageSize.get();
	}
	public static void setPageSize(Integer _pageSize) {
		pageSize.set(_pageSize);
	}
	public static Integer getPageNo() {
		return pageNo.get();
	}
	public static void setPageNo(Integer _pageNo) {
		pageNo.set(_pageNo);;
	}
	public static String getSort() {
		return sort.get();
	}
	public static void setSort(String _sort) {
		sort.set(_sort);;
	}
	public static String getOrder() {
		return order.get();
	}
	public static void setOrder(String _order) {
		order.set(_order);;
	}
	
	
}
