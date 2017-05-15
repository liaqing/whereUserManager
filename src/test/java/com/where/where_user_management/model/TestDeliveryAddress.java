package com.where.where_user_management.model;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.where.where_user_management.dao.DeliveryAddressDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml"})

public class TestDeliveryAddress {
	@Resource
	private DeliveryAddressDao deliveryAddressDao;
	
	
	@Test
	public void testInsert(){
		DeliveryAddress deliveryAddress=new DeliveryAddress();
		deliveryAddress.setId("");
		deliveryAddress.setArea("亳州市");
		deliveryAddress.setConsigneeName("范晓斌");
		deliveryAddress.setPhone("18230407493");
		deliveryAddress.setStreetAddress("光明南大街199号");
		deliveryAddress.setUsersId(1);
		deliveryAddressDao.insert(deliveryAddress);
	}
	@Test
	public void testInsertSelective(){
		DeliveryAddress deliveryAddress=new DeliveryAddress();
		deliveryAddress.setId("");
		deliveryAddress.setArea("安徽省亳州市");
		deliveryAddress.setConsigneeName("李阿庆");
		deliveryAddress.setPhone("18230407493");
		deliveryAddress.setStreetAddress("光明南大街199号");
		deliveryAddress.setUsersId(1);
		deliveryAddressDao.insertSelective(deliveryAddress);
	}
	
	@Test
	public void testUpdateByPrimaryKey(){
		DeliveryAddress deliveryAddress=new DeliveryAddress();
		deliveryAddress.setId("");
		deliveryAddress.setArea("安徽省亳州市");
		deliveryAddress.setConsigneeName("fanfan");
		deliveryAddress.setPhone("18230207737");
		deliveryAddress.setStreetAddress("光明南大街199号");
		deliveryAddress.setUsersId(2);
		deliveryAddressDao.updateByPrimaryKey(deliveryAddress);
	}
	
	@Test
	public void testUpdateByPrimaryKeySelective(){
		DeliveryAddress deliveryAddress=new DeliveryAddress();
		deliveryAddress.setId("");
		deliveryAddress.setArea("市");
		deliveryAddress.setConsigneeName("an");
		deliveryAddress.setPhone("7");
		deliveryAddress.setStreetAddress("号");
		deliveryAddress.setUsersId(2);
		deliveryAddressDao.updateByPrimaryKeySelective(deliveryAddress);
	}
	
	
	@Test
	public void testDeleteByPrimaryKey(){
		
		deliveryAddressDao.deleteByPrimaryKey(1);
	}
	
	@Test
	public void testDeleteByUsersId(){
		
		deliveryAddressDao.deleteByUsersId(2);
	}
	
	@Test
	public void testSelectByPrimaryKey(){
		
		DeliveryAddress deliveryAddress=deliveryAddressDao.selectByPrimaryKey(1);
		
		if(deliveryAddress!=null){
		System.out.println(deliveryAddress.toString());
		}else{
			System.out.println("weikong");
		}
	}
	@Test
	public void testSelectByCondition(){
		
		DeliveryAddress deliveryAddress=new DeliveryAddress();
		deliveryAddress.setConsigneeName("范晓斌");
		List<DeliveryAddress> list=deliveryAddressDao.selectByCondition(deliveryAddress);
		for (DeliveryAddress deliveryAddress2 : list) {
			System.out.println(deliveryAddress2.toString());
		}
	}
	@Test
	public void testSelect(){
		
		List<DeliveryAddress> list=deliveryAddressDao.select();
		for (DeliveryAddress deliveryAddress2 : list) {
			System.out.println(deliveryAddress2.toString());
		}
	}
	
	@Test
	public void testSelectLike(){
		
		DeliveryAddress deliveryAddress=new DeliveryAddress();
		deliveryAddress.setArea("亳州");
		List<DeliveryAddress> list=deliveryAddressDao.selectLike(deliveryAddress);
		for (DeliveryAddress deliveryAddress2 : list) {
			System.out.println(deliveryAddress2.toString());
		}
	}
	

	@Test
	public void testFindCount(){
		
		DeliveryAddress deliveryAddress=new DeliveryAddress();
		deliveryAddress.setUsersId(1);
		Integer is=deliveryAddressDao.findCount(deliveryAddress);
		
			System.out.println(is);
	
	}
	
	
	@Test
	public void testFind(){
		SystemContext.setPageNo(1);
		SystemContext.setPageSize(3);
		DeliveryAddress deliveryAddress=new DeliveryAddress();
		deliveryAddress.setUsersId(1);
		Pager<DeliveryAddress> pager=deliveryAddressDao.find(deliveryAddress);
		
		List<DeliveryAddress> list=pager.getList();
		for (DeliveryAddress deliveryAddress2 : list) {
			System.out.println(deliveryAddress2.toString());
		}
		System.out.println(pager.getTotalNum());
		System.out.println(pager.getTotalPage());
	
	}
}
