package com.reeltalks.service;

import java.util.List;

import com.reeltalks.dto.Movie;
import com.reeltalks.dto.Moviedata;
import com.reeltalks.dto.Tb_Post;

public interface MovieService {
	
	public abstract List<Movie> list();
	public abstract int  insert(Movie dto);
	public abstract int  update( Movie dto);
	public abstract int  delete( int movieid);
	public abstract int find(String movie_id);
	public abstract Moviedata moviedata(String movie_id);
	public abstract int movie_star_rate_calculator(String movie_id);
}
