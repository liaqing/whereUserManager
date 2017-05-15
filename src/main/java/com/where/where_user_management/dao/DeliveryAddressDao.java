package com.where.where_user_management.dao;

import java.util.List;

import com.where.where_user_management.model.DeliveryAddress;
import com.where.where_user_management.model.Pager;

public interface DeliveryAddressDao {
	public DeliveryAddress selectByPrimaryKey(Integer id);
	public List<DeliveryAddress> selectByCondition(DeliveryAddress deliveryAddress);
	public List<DeliveryAddress> select();
	public List<DeliveryAddress> selectLike(DeliveryAddress deliveryAddress);
	public Pager<DeliveryAddress> find(DeliveryAddress deliveryAddress);
	public Integer findCount(DeliveryAddress deliveryAddress);
	public void deleteByPrimaryKey(Integer id);
	public void deleteByUsersId(Integer usersId);
	public void insert(DeliveryAddress deliveryAddress);
	public void insertSelective(DeliveryAddress deliveryAddress);
	public void updateByPrimaryKeySelective(DeliveryAddress deliveryAddress);
	public void updateByPrimaryKey(DeliveryAddress deliveryAddress);
}
