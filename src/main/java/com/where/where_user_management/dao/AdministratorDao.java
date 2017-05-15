package com.where.where_user_management.dao;

import java.util.List;

import com.where.where_user_management.model.Administrator;
import com.where.where_user_management.model.Pager;

public interface AdministratorDao {
	   public Administrator selectByPrimaryKey(Integer id);
	   public List<Administrator> select();
	   public Administrator selectByUsername(Administrator administrator);
	   public List<Administrator> selectLike(Administrator administrator);
		public Pager<Administrator> find(Administrator administrator);
		public Pager<Administrator> findLike(Administrator administrator);
		
		public Integer findCount(Administrator administrator);
		
		public Integer findCountLike(Administrator administrator);
		public int deleteByPrimaryKey(Integer id);
		public int insert(Administrator administrator);
		public int insertSelective(Administrator administrator);
		public int updateByPrimaryKeySelective(Administrator administrator);
		public int updateByPrimaryKey(Administrator administrator);
	   
}
