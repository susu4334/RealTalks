package com.reeltalks.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reeltalks.dao.MovieDao;
import com.reeltalks.dto.Movie;

@Service("myService")
public class MovieOracleService implements MovieService{
	
	@Autowired
	MovieDao dao;
	@Autowired
	SqlSessionTemplate session;
	
	public List<Movie> list(){
		return dao.list(session);
	}

	@Override
	public int insert(Movie dto) {
		return dao.insert(session, dto);
	}
	
	@Override
	public int find(String movie_id) {
		return dao.find(session, movie_id);
	}

	@Override
	public int update(Movie dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int movieid) {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
