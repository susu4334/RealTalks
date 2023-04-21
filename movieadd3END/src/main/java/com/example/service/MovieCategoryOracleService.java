package com.example.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.MovieCategoryDao;
import com.example.dto.MovieCategory;

@Service("myService3")
public class MovieCategoryOracleService implements MovieCategoryService{

	@Autowired
	MovieCategoryDao dao;
	@Autowired
	SqlSessionTemplate session;
	
	@Override
	public List<MovieCategory> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(MovieCategory dto) {
		return dao.insert(session, dto);
	}

	@Override
	public int update(MovieCategory dto) {
		return dao.insert(session, dto);
	}

	@Override
	public int delete(String movie_id) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
}
