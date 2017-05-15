package com.where.where_user_management.model;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.where.where_user_management.service.BusinessService;
import com.where.where_user_management.service.UsersService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml"})

public class BusinessTest {
	@Resource
	private  UsersService usersService;
	@Inject
	private BusinessService BusinessService;
	
	@Test
	public  void testSelect(){
		Users user=new Users();
		
		user=usersService.selectByPrimaryKey(1);
		System.out.println(user.toString());
	}
	
	@Test
	public void testInsert(){
		Users user =new Users();
		user.setUsername("33");
		user.setPassword("dfdfd");
		
		int a=usersService.insert(user);
		System.out.println(a);
	}
	@Test
	public void testinsertSelective(){
		Business business= new Business();
		
		business.setUsername("55");
		business.setPassword("dfdfd");
		
		
		
		BusinessService.insertSelective(business);
	}
	@Test
	public void updateByPrimaryKeySelective(){
		Users user =new Users();
		user.setId(4);
		user.setUsername("煞笔");
		user.setPassword("平平静静");
		user.setAddress("河北省亳州市利辛县");
		user.setRegistrationTime(new Date());
		usersService.updateByPrimaryKeySelective(user);
	}
	@Test
	public void updateByPrimaryKey(){
		Users user =new Users();
		user.setId(4);
		user.setUsername("帅哥");
		user.setPassword("lll静静");
		user.setAddress("河北ghhj市利辛县");
		user.setRegistrationTime(new Date());
		usersService.updateByPrimaryKeySelective(user);
	}
	
	@Test
	public void findCount(){
		Users users=new Users();
		users.setUsername("张三");
		Map<String, Object> map =new HashMap<>();
		map.put("users", users);
		Integer is=usersService.findCount(users);
		System.out.println(is);
	}
	
	@Test
	public void find(){
		SystemContext.setPageNo(13);
		SystemContext.setPageSize(5);
		Users users =new Users();
		users.setUsername("张三");
		Pager<Users> pager=usersService.find(users);
		List<Users> list=pager.getList();
		for (Users user : list) {
			String s =new java.text.SimpleDateFormat("yy/MM/dd HH:mm:ss").format(user.getRegistrationTime());
			System.out.println(s);
			System.out.println(user.toString());
		}
		System.out.println(pager.getTotalNum());
		System.out.println(pager.getTotalPage());
	}
	@Test
	public void findLike(){
		SystemContext.setPageNo(13);
		SystemContext.setPageSize(5);
		Users users =new Users();
		users.setUsername("三");
		Pager<Users> pager=usersService.findLike(users);
		List<Users> list=pager.getList();
		for (Users user : list) {
			String s =new java.text.SimpleDateFormat("yy/MM/dd HH:mm:ss").format(user.getRegistrationTime());
			System.out.println(s);
			System.out.println(user.toString());
		}
		System.out.println(pager.getTotalNum());
		System.out.println(pager.getTotalPage());
	}
	
	
	//把date日期类型转换为Timestamp类型，防止在插入数据库的时候时分秒丢失
		public java.sql.Timestamp getTimestamp(Date date) {
			return new java.sql.Timestamp(date.getTime());
		}
}
