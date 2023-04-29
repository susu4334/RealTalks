package com.reeltalks.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.reeltalks.dto.MovieCategory;
@Repository
public class MovieCategoryOracleDAO implements MovieCategoryDao{

	@Override
	public List<MovieCategory> list(SqlSessionTemplate session) {
		List<MovieCategory> list = session.selectList("selectAll");
		return list;
	}

	@Override
	public int insert(SqlSessionTemplate session, MovieCategory dto) {
		return session.insert("insertmoviecategory", dto);
	}
	

	@Override
	public int update(SqlSessionTemplate session, MovieCategory dto) {
		return 0;
	}

	@Override
	public int delete(SqlSessionTemplate session, String movie_id) {
		return 0;
	}

	

}
