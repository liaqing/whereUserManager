package com.where.where_user_management.model;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.where.where_user_management.dao.BusinessDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml"})

public class TestBusiness {
	@Resource
	private BusinessDao businessDao;
	
	@Test
	public void testInsert(){
		Business business=new Business();
		business.setId(1);
		business.setUsername("zheyang");
		business.setPassword("不是这样");
		businessDao.insert(business);
	}
	
	@Test
	public void testInsertSelective(){
		Business business=new Business();
		business.setId(2);
		business.setUsername("g");
		business.setPassword("这样");
		businessDao.insertSelective(business);
	}
	@Test
	public void testSelectByPrimaryKey(){
		
		Business business=new Business();
		
		business=businessDao.selectByPrimaryKey(2);
		
		System.out.println(business);
	}
	
	@Test
	public void testSelect(){
		
		
		
		List<Business> list=businessDao.select();
		
		for (Business business : list) {
			System.out.println(business.toString());
		}
	}
	
	@Test
	public void testSelectLike(){
		
		Business business=new Business();
		business.setUsername("g");
		
		List<Business> list=businessDao.selectLike(business);
		
		for (Business business2 : list) {
			System.out.println(business2.toString());
		}
	}
	
	@Test
	public void testFindCount(){
		
		Business business=new Business();
		business.setUsername("g");
		
		Integer list=businessDao.findCount(business);
		
		System.out.println(list);
	}
	@Test
	public void testFindCountLike(){
		
		Business business=new Business();
		business.setUsername("g");
		
		Integer list=businessDao.findCountLike(business);
		
		System.out.println(list);
	}
	
	@Test
	public void testUpdateByPrimaryKeySelective(){
		
		Business business=new Business();
		business.setId(2);
		business.setUsername("gggg");
		business.setEmail("gggggggggg");
		
		businessDao.updateByPrimaryKeySelective(business);
		
		
	}
	
	@Test
	public void testUpdateByPrimaryKey(){
		
		Business business=new Business();
		business.setId(2);
		business.setPassword("jjj");
		business.setUsername("就是指");
		business.setEmail("gg");
		
		businessDao.updateByPrimaryKey(business);
		
		
	}
	
	@Test
	public void testDeleteByPrimaryKey(){
		businessDao.deleteByPrimaryKey(1);
		
	}
	
	
	@Test
	public void testFindLike(){
		SystemContext.setPageNo(1);
		SystemContext.setPageSize(5);
		Business business=new Business();
		business.setUsername("j");
		
		Pager<Business> pager=businessDao.findLike(business);
		
		List<Business> list=pager.getList();
		for (Business business2 : list) {
			System.out.println(business2.toString());
		}
		System.out.println(pager.getTotalNum());
		System.out.println(pager.getTotalPage());
		
	}
	
}
