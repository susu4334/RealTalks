package com.example.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.example.dto.Movie;

public interface MovieDao {
	
	public abstract List<Movie> list(SqlSessionTemplate session);
	public abstract int  insert(SqlSessionTemplate session, Movie dto);
	public abstract int  update(SqlSessionTemplate session, Movie dto);
	public abstract int  delete(SqlSessionTemplate session, int movieid);
	public abstract int find(SqlSessionTemplate session, String movie_id);
}
