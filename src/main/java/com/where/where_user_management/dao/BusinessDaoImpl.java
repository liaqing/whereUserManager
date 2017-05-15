package com.where.where_user_management.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.where.where_user_management.model.Business;
import com.where.where_user_management.model.Pager;
import com.where.where_user_management.model.SystemContext;

@Repository(value="businessDao")
public class BusinessDaoImpl implements BusinessDao {

	@Resource
	private  SqlSessionTemplate sqlSession;
	
	@Override
	public Business selectByPrimaryKey(Integer id) {
		
		return sqlSession.selectOne(Business.class.getName()+".selectByPrimaryKey", id);
	}

	@Override
	public List<Business> select() {
		List<Business> list=sqlSession.selectList(Business.class.getName()+".select");
		return list;
	}

	@Override
	public List<Business> selectLike(Business business) {
		return sqlSession.selectList(Business.class.getName()+".selectLike", business);
	}

	@Override
	public Pager<Business> find(Business business) {
		Integer pageNo=SystemContext.getPageNo();
		Integer pageSize =SystemContext.getPageSize();
		Map<String, Object> map=new HashMap<>();
		map.put("pageNo", pageNo);
		map.put("pageSize", pageSize);
		map.put("business", business);
		List<Business> list=sqlSession.selectList(Business.class.getName()+".find", map);
		Pager<Business> pager=new Pager<>();
		pager.setList(list);
		pager.setPageNo(pageNo);
		pager.setPageSize(pageSize);
		Integer totalNum=sqlSession.selectOne(Business.class.getName()+".findCount", map);
		pager.setTotalNum(totalNum);
		return pager;
	}

	@Override
	public Pager<Business> findLike(Business business) {
		Integer pageNo=SystemContext.getPageNo();
		Integer pageSize =SystemContext.getPageSize();
		Map<String, Object> map=new HashMap<>();
		map.put("pageNo", pageNo);
		map.put("pageSize", pageSize);
		map.put("business", business);
		List<Business> list=sqlSession.selectList(Business.class.getName()+".findLike", map);
		Pager<Business> pager=new Pager<>();
		pager.setList(list);
		pager.setPageNo(pageNo);
		pager.setPageSize(pageSize);
		Integer totalNum=sqlSession.selectOne(Business.class.getName()+".findCountLike", map);
		pager.setTotalNum(totalNum);
		return pager;
	}

	@Override
	public Integer findCount(Business business) {
		Map<String, Object> map =new HashMap<>();
		map.put("business", business);
		return sqlSession.selectOne(Business.class.getName()+".findCount", map);
	}

	@Override
	public Integer findCountLike(Business business) {
		Map<String, Object> map =new HashMap<>();
		map.put("business", business);
		return sqlSession.selectOne(Business.class.getName()+".findCountLike", map);
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		return sqlSession.delete(Business.class.getName()+".deleteByPrimaryKey", id);

	}

	@Override
	public int insert(Business business) {
		return sqlSession.insert(Business.class.getName()+".insert", business);

	}

	@Override
	public int  insertSelective(Business business) {
		return sqlSession.insert(Business.class.getName()+".insertSelective", business);

	}

	@Override
	public int  updateByPrimaryKeySelective(Business business) {
		return sqlSession.update(Business.class.getName()+".updateByPrimaryKeySelective", business);

	}

	@Override
	public int  updateByPrimaryKey(Business business) {
		return sqlSession.update(Business.class.getName()+".updateByPrimaryKey", business);

	}

	@Override
	public Business selectByUsername(Business business) {
		
		return sqlSession.selectOne(Business.class.getName()+".selectByUsername", business);
	}

}
