package com.where.where_user_management.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.where.where_user_management.model.Pager;
import com.where.where_user_management.model.SystemContext;
import com.where.where_user_management.model.Users;

@Repository(value="usersDao")
public class UsersDaoImpl implements UsersDao {
	
	@Resource
	private  SqlSessionTemplate sqlSession;

	@Override
	public Users selectByPrimaryKey(Integer id) {
		Users user =new Users();
		user=sqlSession.selectOne(Users.class.getName()+".selectByPrimaryKey", id);
		return user;
	}
	@Override
	public List<Users> select() {
		List<Users> list=sqlSession.selectList(Users.class.getName()+".select");
		return list;
	}
	@Override
	public List<Users> selectLike(Users users) {
		List<Users> list =sqlSession.selectList(Users.class.getName()+".selectLike", users);
		return list;
	}
	@Override
	public Pager<Users> find(Users users) {
		Integer pageNo=SystemContext.getPageNo();
		Integer pageSize=SystemContext.getPageSize();
		
		Map<String, Object> map2=new HashMap<>();
		map2.put("pageNo", pageNo);
		map2.put("pageSize", pageSize);
		map2.put("users", users);
		List<Users> list=sqlSession.selectList(Users.class.getName()+".find", map2);
		Pager<Users> pager=new Pager<>();
		pager.setList(list);
		pager.setPageNo(pageNo);
		pager.setPageSize(pageSize);
		Integer totalNum=sqlSession.selectOne(Users.class.getName()+".findCount", map2);
		pager.setTotalNum(totalNum);
		return pager;
	}
	@Override
	public Pager<Users> findLike(Users users) {
		Integer pageNo=SystemContext.getPageNo();
		Integer pageSize=SystemContext.getPageSize();
		
		Map<String, Object> map2=new HashMap<>();
		map2.put("pageNo", pageNo);
		map2.put("pageSize", pageSize);
		map2.put("users", users);
		List<Users> list=sqlSession.selectList(Users.class.getName()+".findLike", map2);
		Pager<Users> pager=new Pager<>();
		pager.setList(list);
		pager.setPageNo(pageNo);
		pager.setPageSize(pageSize);
		Integer totalNum=sqlSession.selectOne(Users.class.getName()+".findCountLike", map2);
		pager.setTotalNum(totalNum);
		return pager;
	}
	@Override
	public int deleteByPrimaryKey(Integer id) {
		return sqlSession.delete(Users.class.getName()+".deleteByPrimaryKey", id);
	}
	@Override
	public int insert(Users user) {
		return sqlSession.insert(Users.class.getName()+".insert", user);
		
	}
	@Override
	public int insertSelective(Users user) {
		return sqlSession.insert(Users.class.getName()+".insertSelective", user);
		
	}
	@Override
	public int updateByPrimaryKeySelective(Users user) {
		return sqlSession.update(Users.class.getName()+".updateByPrimaryKeySelective", user);
		
	}
	@Override
	public int updateByPrimaryKey(Users user) {
		return sqlSession.update(Users.class.getName()+".updateByPrimaryKey", user);
		
	}
	@Override
	public Integer findCount(Users users) {
		Map<String, Object> map=new HashMap<>();
		map.put("users", users);
		return sqlSession.selectOne(Users.class.getName()+".findCount", map);
	}
	@Override
	public Integer findCountLike(Users users) {
		Map<String, Object> map =new HashMap<>();
		map.put("users", users);
		return sqlSession.selectOne(Users.class.getName()+".findCountLike", map);
	}
	@Override
	public Users selectByUsername(Users users) {
		
		return sqlSession.selectOne(Users.class.getName()+".selectByUsername", users);
	}
	
}
