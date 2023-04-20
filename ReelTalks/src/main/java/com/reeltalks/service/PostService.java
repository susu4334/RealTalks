package com.reeltalks.service;

import com.reeltalks.dto.Tb_Post;

public interface PostService {
	

	public abstract int addPost(Tb_Post post);

	public abstract Tb_Post selectOne(int post_id);

	public abstract int updatePost(Tb_Post post);

	public abstract void updateView(int post_id);

	public abstract int deletePost(int post_id);

	public abstract String movieTitle(String movie_id);

	public abstract String userName(String user_id);

	public abstract int addPostSelect(String user_id);
	
}
