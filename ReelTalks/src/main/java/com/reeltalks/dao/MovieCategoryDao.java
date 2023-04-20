package com.reeltalks.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.reeltalks.dto.MovieCategory;

public interface MovieCategoryDao {
	
	public abstract List<MovieCategory> list(SqlSessionTemplate session);
	public abstract int  insert(SqlSessionTemplate session, MovieCategory dto);
	public abstract int  update(SqlSessionTemplate session, MovieCategory dto);
	public abstract int  delete(SqlSessionTemplate session, String movie_id);
}
