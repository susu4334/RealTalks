package com.reeltalks.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.reeltalks.dto.Tb_Post;

public interface PostDAO {

	public abstract int addPost(SqlSessionTemplate session, Tb_Post post);

	public abstract Tb_Post selectOne(SqlSessionTemplate session, int post_id);

	public abstract int updatePost(SqlSessionTemplate session, Tb_Post post);

	public abstract void updateView(SqlSessionTemplate session, int post_id);

	public abstract int deletePost(SqlSessionTemplate session, int post_id);

	public abstract String movieTitle(SqlSessionTemplate session, String movie_id);

	public abstract String userName(SqlSessionTemplate session, String user_id);

	public abstract int addPostSelect(SqlSessionTemplate session, String user_id);

	public abstract List<Tb_Post> selectList(SqlSessionTemplate session, String movie_id);

}
