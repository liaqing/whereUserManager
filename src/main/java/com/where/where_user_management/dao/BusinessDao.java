package com.where.where_user_management.dao;

import java.util.List;

import com.where.where_user_management.model.Business;
import com.where.where_user_management.model.Pager;

public interface BusinessDao {
	 public Business selectByPrimaryKey(Integer id);
	   public List<Business> select();
	   public Business selectByUsername(Business business);
	   public List<Business> selectLike(Business business);
		public Pager<Business> find(Business business);
		public Pager<Business> findLike(Business business);
		
		public Integer findCount(Business business);
		
		public Integer findCountLike(Business business);
		public int deleteByPrimaryKey(Integer id);
		public int insert(Business business);
		public int insertSelective(Business business);
		public int updateByPrimaryKeySelective(Business business);
		public int updateByPrimaryKey(Business business);
}
