package com.example.service;

import java.util.List;

import com.example.dto.MovieCategory;

public interface MovieCategoryService {
	
	public abstract List<MovieCategory> list();
	public abstract int  insert(MovieCategory dto);
	public abstract int  update( MovieCategory dto);
	public abstract int  delete( String movie_id);
}
