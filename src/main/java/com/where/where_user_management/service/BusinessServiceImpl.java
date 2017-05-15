package com.where.where_user_management.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.where.where_user_management.dao.BusinessDao;
import com.where.where_user_management.model.Business;
import com.where.where_user_management.model.Pager;

@Service("businessService")
public class BusinessServiceImpl implements BusinessService {
	@Resource
	private BusinessDao businessDao;
	private BusinessPasswordHelper passwordHelper=new BusinessPasswordHelper();
	@Override
	public Business selectByPrimaryKey(Integer id) {
		return businessDao.selectByPrimaryKey(id);
	}

	@Override
	public List<Business> select() {
		return businessDao.select();
	}

	@Override
	public List<Business> selectLike(Business user) {
		return businessDao.selectLike(user);
	}

	@Override
	public Pager<Business> find(Business Business) {
		return businessDao.find(Business);
	}

	@Override
	public Pager<Business> findLike(Business Business) {
		return businessDao.findLike(Business);
	}

	@Override
	public Integer findCount(Business Business) {
		return businessDao.findCount(Business);
	}

	@Override
	public Integer findCountLike(Business Business) {
		return businessDao.findCountLike(Business);
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		return businessDao.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Business business) {
		passwordHelper.encryptPassword(business);
		return businessDao.insert(business);
	}

	@Override
	public int insertSelective(Business user) {
		passwordHelper.encryptPassword(user);
		return businessDao.insertSelective(user);
	}

	@Override
	public int updateByPrimaryKeySelective(Business user) {
		return businessDao.updateByPrimaryKeySelective(user);

	}

	@Override
	public int updateByPrimaryKey(Business user) {
		return businessDao.updateByPrimaryKey(user);
	}

	@Override
	public Business selectByName(Business Business) {
		
		return businessDao.selectByUsername(Business);
	}

}
