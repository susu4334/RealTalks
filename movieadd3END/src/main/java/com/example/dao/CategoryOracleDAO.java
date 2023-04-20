package com.example.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.example.dto.Category;
@Repository
public class CategoryOracleDAO implements CategoryDao{

	@Override
	public List<Category> list(SqlSessionTemplate session) {
		List<Category> list = session.selectList("selectAll");
		return list;
	}

	@Override
	public int insert(SqlSessionTemplate session, Category dto) {
		return session.insert("insertcategory", dto);
	}
	
	@Override
	public int find(SqlSessionTemplate session, String category_id) {
		int n = session.selectOne("findcategory", category_id);
		return n;
	}

	@Override
	public int update(SqlSessionTemplate session, Category dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(SqlSessionTemplate session, String category_id) {
		// TODO Auto-generated method stub
		return 0;
	}

	

}
