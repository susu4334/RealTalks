package com.example.service;

import java.util.List;

import com.example.dto.Category;

public interface CategoryService {
	
	public abstract List<Category> list();
	public abstract int  insert(Category dto);
	public abstract int  find(String category_id);
	public abstract int  update( Category dto);
	public abstract int  delete( String category_id);
}
