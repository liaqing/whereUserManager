package com.where.where_user_management.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.where.where_user_management.dao.AdministratorDao;
import com.where.where_user_management.model.Administrator;
import com.where.where_user_management.model.Pager;

@Service("AdministratorService")
public class AdministratorServiceImpl implements AdministratorService {
	@Resource
	private AdministratorDao administratorDao;
	private AdministratorPasswordHelper passwordHelper=new AdministratorPasswordHelper();
	@Override
	public Administrator selectByPrimaryKey(Integer id) {
		return administratorDao.selectByPrimaryKey(id);
	}

	@Override
	public List<Administrator> select() {
		return administratorDao.select();
	}

	@Override
	public List<Administrator> selectLike(Administrator administrator) {
		return administratorDao.selectLike(administrator);
	}

	@Override
	public Pager<Administrator> find(Administrator administrator) {
		return administratorDao.find(administrator);
	}

	@Override
	public Pager<Administrator> findLike(Administrator administrator) {
		return administratorDao.findLike(administrator);
	}

	@Override
	public Integer findCount(Administrator administrator) {
		return administratorDao.findCount(administrator);
	}

	@Override
	public Integer findCountLike(Administrator administrator) {
		return administratorDao.findCountLike(administrator);
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		return administratorDao.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Administrator administrator) {
		passwordHelper.encryptPassword(administrator);
		return administratorDao.insert(administrator);
	}

	@Override
	public int insertSelective(Administrator administrator) {
		passwordHelper.encryptPassword(administrator);
		return administratorDao.insertSelective(administrator);
	}

	@Override
	public int updateByPrimaryKeySelective(Administrator administrator) {
		return administratorDao.updateByPrimaryKeySelective(administrator);

	}

	@Override
	public int updateByPrimaryKey(Administrator administrator) {
		return administratorDao.updateByPrimaryKey(administrator);
	}

	@Override
	public Administrator selectByName(Administrator administrator) {
		
		return administratorDao.selectByUsername(administrator);
	}

}
