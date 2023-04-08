package com.example.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.CategoryDao;
import com.example.dto.Category;

@Service("myService2")
public class CategoryOracleService implements CategoryService{
	
	@Autowired
	CategoryDao dao;
	@Autowired
	SqlSessionTemplate session;
	
	public List<Category> list(){
		return dao.list(session);
	}

	@Override
	public int insert(Category dto) {
		return dao.insert(session, dto);
	}
	
	@Override
	public int find(String category_id) {
		int n = dao.find(session, category_id);
		return n;
	}

	@Override
	public int update(Category dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String category_id) {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
