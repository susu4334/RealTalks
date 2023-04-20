package com.example.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.example.dto.Category;

public interface CategoryDao {
	
	public abstract List<Category> list(SqlSessionTemplate session);
	public abstract int  insert(SqlSessionTemplate session, Category dto);
	public abstract int  find(SqlSessionTemplate session, String category_id);
	public abstract int  update(SqlSessionTemplate session, Category dto);
	public abstract int  delete(SqlSessionTemplate session, String category_id);
}
