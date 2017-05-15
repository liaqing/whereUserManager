package com.where.where_user_management.model;


import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.where.where_user_management.service.AdministratorService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml"})
public class TestAdministrator {
	@Resource
	AdministratorService administratorService;
	
	@Test
	public void testInsert() throws ParseException{
		
		
		Administrator administrator =new Administrator();
		administrator.setId(3);
		administrator.setUsername("不是");
		administrator.setPassword("fff");
		
		
		administrator.setRegistrationTime(getTimestamp(new Date()));
		administratorService.insertSelective(administrator);
	}
	
	@Test
	public void testInsertSelective() throws ParseException{
		
		
		Administrator administrator =new Administrator();
		
		administrator.setUsername("admin");
		administrator.setPassword("admin");
		administrator.setPhone("110");
		administrator.setAddress("北京市昭阳区");
		administrator.setSex((short) 1);
		administrator.setEmail("110@110.com");
		
		
		
		administratorService.insertSelective(administrator);
	}
	
	
	@Test
	public void testSelectByPrimaryKey(){
		Administrator administrator =new Administrator();
		
		
		administrator=administratorService.selectByPrimaryKey(9);
		System.out.println(administrator.toString());
	}
	
	@Test
	public void testSelect(){
		
		
		
		List<Administrator> list=administratorService.select();
		for (Administrator administrator2 : list) {
			System.out.println(administrator2.toString());
		}
		
	}
	
	@Test
	public void testSelectLike(){
		
		Administrator administrator=new Administrator();
		administrator.setUsername("不");
		
		List<Administrator> list=administratorService.selectLike(administrator);
		for (Administrator administrator2 : list) {
			System.out.println(administrator2.toString());
		}
		
	}
	@Test
	public void testFind(){
		SystemContext.setPageNo(2);
		SystemContext.setPageSize(5);
		Administrator administrator=new Administrator();
		administrator.setUsername("不是");
		
		Pager<Administrator> pager=administratorService.find(administrator);
		
		List<Administrator> list=pager.getList();
		for (Administrator administrator2 : list) {
			System.out.println(administrator2.toString());
		}
		System.out.println(pager.getTotalNum());
		System.out.println(pager.getTotalPage());
		
	}
	@Test
	public void testFindLike(){
		SystemContext.setPageNo(2);
		SystemContext.setPageSize(3);
		Administrator administrator=new Administrator();
		administrator.setUsername("不");
		
		Pager<Administrator> pager=administratorService.findLike(administrator);
		
		List<Administrator> list=pager.getList();
		for (Administrator administrator2 : list) {
			System.out.println(administrator2.toString());
		}
		System.out.println(pager.getTotalNum());
		System.out.println(pager.getTotalPage());
		
	}
	
	
	
	@Test
	public void testSelectCount(){
		Administrator administrator=new Administrator();
		Integer is=administratorService.findCount(administrator);
		System.out.println(is);
	}
	@Test
	public void testSelectCountLike(){
		Administrator administrator=new Administrator();
		Integer is=administratorService.findCountLike(administrator);
		System.out.println(is);
	}
	
	
	@Test
	public void updateByPrimaryKeySelective(){
		Administrator administrator=new Administrator();
		administrator.setId(11);
		administrator.setUsername("上啊");
		administrator.setPassword("caoa");
		administratorService.updateByPrimaryKeySelective(administrator);
		
	}
	@Test
	public void updateByPrimaryKey(){
		Administrator administrator=new Administrator();
		administrator.setId(11);
		administrator.setUsername("啊");
		administrator.setPassword("a");
		administratorService.updateByPrimaryKeySelective(administrator);
		
	}
	
	
	//把date日期类型转换为Timestamp类型，防止在插入数据库的时候时分秒丢失
	public java.sql.Timestamp getTimestamp(Date date) {
		return new java.sql.Timestamp(date.getTime());
		}
}
