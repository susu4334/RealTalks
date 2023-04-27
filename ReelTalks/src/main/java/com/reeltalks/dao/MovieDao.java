package com.reeltalks.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.reeltalks.dto.Movie;
import com.reeltalks.dto.Moviedata;
import com.reeltalks.dto.Tb_Post;

public interface MovieDao {
	
	public abstract List<Movie> list(SqlSessionTemplate session);
	public abstract int  insert(SqlSessionTemplate session, Movie dto);
	public abstract int  update(SqlSessionTemplate session, Movie dto);
	public abstract int  delete(SqlSessionTemplate session, int movieid);
	public abstract int find(SqlSessionTemplate session, String movie_id);
	public abstract Moviedata moviedata(SqlSessionTemplate session, String movie_id);
	public abstract int movie_star_rate_calculator(SqlSessionTemplate session, String movie_id);
}
