package com.where.where_user_management.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.where.where_user_management.model.DeliveryAddress;
import com.where.where_user_management.model.Pager;
import com.where.where_user_management.model.SystemContext;

@Repository(value="deliveryAddressDao")
public class DeliveryAddressDaoImpl implements DeliveryAddressDao {

	@Resource
	private  SqlSessionTemplate sqlSession;
	
	
	@Override
	public DeliveryAddress selectByPrimaryKey(Integer id) {
		
		return sqlSession.selectOne(DeliveryAddress.class.getName()+".selectByPrimaryKey", id);
	}

	@Override
	public List<DeliveryAddress> selectByCondition(DeliveryAddress deliveryAddress) {
		return sqlSession.selectList(DeliveryAddress.class.getName()+".selectByCondition", deliveryAddress);
	}

	@Override
	public List<DeliveryAddress> select() {
		
		return sqlSession.selectList(DeliveryAddress.class.getName()+".select");
	}

	@Override
	public List<DeliveryAddress> selectLike(DeliveryAddress deliveryAddress) {
		
		return sqlSession.selectList(DeliveryAddress.class.getName()+".selectLike",deliveryAddress);
	}

	@Override
	public Pager<DeliveryAddress> find(DeliveryAddress deliveryAddress) {
		Integer pageNo=SystemContext.getPageNo();
		Integer pageSize =SystemContext.getPageSize();
		Map<String, Object> map=new HashMap<>();
		map.put("pageNo", pageNo);
		map.put("pageSize", pageSize);
		map.put("deliveryAddress", deliveryAddress);
		List<DeliveryAddress> list=sqlSession.selectList(DeliveryAddress.class.getName()+".find", map);
		Pager<DeliveryAddress> pager=new Pager<>();
		pager.setList(list);
		pager.setPageNo(pageNo);
		pager.setPageSize(pageSize);
		Integer totalNum=sqlSession.selectOne(DeliveryAddress.class.getName()+".findCount", map);
		pager.setTotalNum(totalNum);
		return pager;
	}

	@Override
	public Integer findCount(DeliveryAddress deliveryAddress) {
		
		Map<String, Object> map=new HashMap<>();
		map.put("deliveryAddress", deliveryAddress);
		return sqlSession.selectOne(DeliveryAddress.class.getName()+".findCount", map);
	}

	@Override
	public void deleteByPrimaryKey(Integer id) {
		sqlSession.delete(DeliveryAddress.class.getName()+".deleteByPrimaryKey", id);

	}

	@Override
	public void deleteByUsersId(Integer usersId) {
		sqlSession.delete(DeliveryAddress.class.getName()+".deleteByUsersId", usersId);

	}

	@Override
	public void insert(DeliveryAddress deliveryAddress) {
		sqlSession.insert(DeliveryAddress.class.getName()+".insert", deliveryAddress);

	}

	@Override
	public void insertSelective(DeliveryAddress deliveryAddress) {
		sqlSession.insert(DeliveryAddress.class.getName()+".insertSelective", deliveryAddress);

	}

	@Override
	public void updateByPrimaryKeySelective(DeliveryAddress deliveryAddress) {
		sqlSession.update(DeliveryAddress.class.getName()+".updateByPrimaryKeySelective", deliveryAddress);

	}

	@Override
	public void updateByPrimaryKey(DeliveryAddress deliveryAddress) {
		sqlSession.update(DeliveryAddress.class.getName()+".updateByPrimaryKey", deliveryAddress);

	}

}
