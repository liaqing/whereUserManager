package com.where.where_user_management.dao;

import java.util.List;

import com.where.where_user_management.model.Pager;
import com.where.where_user_management.model.Users;

public interface UsersDao {
	public Users selectByPrimaryKey(Integer id);
	public List<Users> select();
	public Users selectByUsername(Users users);
	public List<Users> selectLike(Users users);
	public Pager<Users> find(Users users);
	public Pager<Users> findLike(Users users);
	
	public Integer findCount(Users users);
	
	public Integer findCountLike(Users users);
	public int deleteByPrimaryKey(Integer id);
	public int insert(Users user);
	public int insertSelective(Users user);
	public int updateByPrimaryKeySelective(Users user);
	public int updateByPrimaryKey(Users user);
	
}
