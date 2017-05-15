package com.where.where_user_management.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.where.where_user_management.model.Administrator;
import com.where.where_user_management.model.Pager;
import com.where.where_user_management.model.SystemContext;

@Repository(value="administratorDao")
public class AdministratorDaoImpl implements AdministratorDao {
	
	@Resource
	private  SqlSessionTemplate sqlSession;
	@Override
	public Administrator selectByPrimaryKey(Integer id) {
		
		return sqlSession.selectOne(Administrator.class.getName()+".selectByPrimaryKey", id);
	}

	@Override
	public List<Administrator> select() {
		
		return sqlSession.selectList(Administrator.class.getName()+".select");
	}

	@Override
	public List<Administrator> selectLike(Administrator administrator) {
		
		return sqlSession.selectList(Administrator.class.getName()+".selectLike", administrator);
	}

	@Override
	public Pager<Administrator> find(Administrator administrator) {
		Integer pageNo=SystemContext.getPageNo();
		Integer pageSize =SystemContext.getPageSize();
		Map<String, Object> map=new HashMap<>();
		map.put("pageNo", pageNo);
		map.put("pageSize", pageSize);
		map.put("administrator", administrator);
		List<Administrator> list=sqlSession.selectList(Administrator.class.getName()+".find", map);
		Pager<Administrator> pager=new Pager<>();
		pager.setList(list);
		pager.setPageNo(pageNo);
		pager.setPageSize(pageSize);
		Integer totalNum=sqlSession.selectOne(Administrator.class.getName()+".findCount", map);
		pager.setTotalNum(totalNum);
		return pager;
	}

	@Override
	public Pager<Administrator> findLike(Administrator administrator) {
		Integer pageNo=SystemContext.getPageNo();
		Integer pageSize =SystemContext.getPageSize();
		Map<String, Object> map=new HashMap<>();
		map.put("pageNo", pageNo);
		map.put("pageSize", pageSize);
		map.put("administrator", administrator);
		List<Administrator> list=sqlSession.selectList(Administrator.class.getName()+".findLike", map);
		Pager<Administrator> pager=new Pager<>();
		pager.setList(list);
		pager.setPageNo(pageNo);
		pager.setPageSize(pageSize);
		Integer totalNum=sqlSession.selectOne(Administrator.class.getName()+".findCountLike", map);
		pager.setTotalNum(totalNum);
		return pager;
	}

	@Override
	public Integer findCount(Administrator administrator) {
		Map<String, Object> map =new HashMap<>();
		map.put("administrator", administrator);
		return sqlSession.selectOne(Administrator.class.getName()+".findCount", map);
	}

	@Override
	public Integer findCountLike(Administrator administrator) {
		Map<String, Object> map =new HashMap<>();
		map.put("administrator", administrator);
		return sqlSession.selectOne(Administrator.class.getName()+".findCountLike", map);
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		return sqlSession.delete(Administrator.class.getName()+".deleteByPrimaryKey", id);

	}

	@Override
	public int insert(Administrator administrator) {
		return sqlSession.insert(Administrator.class.getName()+".insert", administrator);

	}

	@Override
	public int insertSelective(Administrator administrator) {
		return sqlSession.insert(Administrator.class.getName()+".insertSelective", administrator);

	}

	@Override
	public int updateByPrimaryKeySelective(Administrator administrator) {
		return sqlSession.update(Administrator.class.getCanonicalName()+".updateByPrimaryKeySelective", administrator);

	}

	@Override
	public int updateByPrimaryKey(Administrator administrator) {
		return sqlSession.update(Administrator.class.getName()+".updateByPrimaryKey", administrator);
	}

	@Override
	public Administrator selectByUsername(Administrator administrator) {
		return sqlSession.selectOne(Administrator.class.getCanonicalName()+".selectByUsername", administrator);
	}

}
