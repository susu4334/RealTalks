package com.reeltalks.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.reeltalks.dto.Tb_Post;

@Repository
public class PostDAOImp implements PostDAO{

	@Override
	public List<Tb_Post> selectList(SqlSessionTemplate session, String movie_id) {
		List<Tb_Post> list = session.selectList("selectPostList", movie_id);
		return list;
	}
	
	
	//게시물 등록 
	@Override
	public int addPost(SqlSessionTemplate session, Tb_Post post) {
		int num=session.insert("addPost",post);
		return num;
	}

	//게시물 상세조회
	@Override
	public Tb_Post selectOne(SqlSessionTemplate session, int post_id) {
		return session.selectOne("selectOne",post_id);
	}

	//게시물 수정 
	@Override
	public int updatePost(SqlSessionTemplate session, Tb_Post post) {
		int num=session.update("updatePost",post);
		return num;
	}

	//조회수 업데이트
	@Override
	//@Mapper
	public void updateView(SqlSessionTemplate session, int post_id) {
		int num=session.update("updateView",post_id);
		System.out.println(num);
	}
	
	
	//게시물 삭제 
	@Override
	public int deletePost(SqlSessionTemplate session, int post_id) {
		int num=session.delete("deletePost",post_id);
		return num;
	}

	//영화 제목 조회
	@Override
	public String movieTitle(SqlSessionTemplate session, String movie_id) {
		String movie_title=session.selectOne("movieTitle",movie_id);
		return movie_title;
	}
	
	//닉네임 조회
	@Override
	public String userName(SqlSessionTemplate session, String user_id) {
		return session.selectOne("userName",user_id);
	}

	//insert게시물 번호 조회
	@Override
	public int addPostSelect(SqlSessionTemplate session, String user_id) {
		return session.selectOne("addPostSelect",user_id);
	}
	


}
