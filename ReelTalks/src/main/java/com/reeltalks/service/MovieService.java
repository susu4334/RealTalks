package com.reeltalks.service;

import java.util.List;

import com.reeltalks.dto.Movie;

public interface MovieService {
	
	public abstract List<Movie> list();
	public abstract int  insert(Movie dto);
	public abstract int  update( Movie dto);
	public abstract int  delete( int movieid);
	public abstract int find(String movie_id);
}