package com.where.where_user_management.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.where.where_user_management.dao.UsersDao;
import com.where.where_user_management.model.Pager;
import com.where.where_user_management.model.Users;

@Service("usersService")
public class UsersServiceImpl implements UsersService {
	@Resource
	private UsersDao usersDao;
	private PasswordHelper passwordHelper=new PasswordHelper();
	@Override
	public Users selectByPrimaryKey(Integer id) {
		return usersDao.selectByPrimaryKey(id);
	}

	@Override
	public List<Users> select() {
		return usersDao.select();
	}

	@Override
	public List<Users> selectLike(Users user) {
		return usersDao.selectLike(user);
	}

	@Override
	public Pager<Users> find(Users users) {
		return usersDao.find(users);
	}

	@Override
	public Pager<Users> findLike(Users users) {
		return usersDao.findLike(users);
	}

	@Override
	public Integer findCount(Users users) {
		return usersDao.findCount(users);
	}

	@Override
	public Integer findCountLike(Users users) {
		return usersDao.findCountLike(users);
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		return usersDao.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Users user) {
		passwordHelper.encryptPassword(user);
		return usersDao.insert(user);
	}

	@Override
	public int insertSelective(Users user) {
		passwordHelper.encryptPassword(user);
		return usersDao.insertSelective(user);
	}

	@Override
	public int updateByPrimaryKeySelective(Users user) {
		return usersDao.updateByPrimaryKeySelective(user);

	}

	@Override
	public int updateByPrimaryKey(Users user) {
		return usersDao.updateByPrimaryKey(user);
	}

	@Override
	public Users selectByName(Users users) {
		
		return usersDao.selectByUsername(users);
	}

}
