package com.reeltalks.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reeltalks.dao.PostDAO;
import com.reeltalks.dto.Tb_Post;

@Service
public class PostServiceImp implements PostService {

	@Autowired
	PostDAO dao;
	@Autowired
	SqlSessionTemplate session;
	
	
	//게시물 등록
	@Override
	public int addPost(Tb_Post post) {
		System.out.println("service: "+post);
		int num=dao.addPost(session,post);
		return num;
	}
	
	//게시물 조회
	@Override
	public Tb_Post selectOne(int post_id) {
		return dao.selectOne(session,post_id);
	}
	
	//게시물 수정
	@Override
	public int updatePost(Tb_Post post) {
		int num=dao.updatePost(session, post);
		return num;
	}

	//조회수 업데이트
	@Override
	public void updateView(int post_id) {
		dao.updateView(session,post_id);
		
	}

	//게시물 삭제
	@Override
	public int deletePost(int post_id) {
		int num=dao.deletePost(session, post_id);
		return num;
	}
	
	
	//영화제목 조회
	@Override
	public String movieTitle(String movie_id) {
		return dao.movieTitle(session,movie_id);
	}

	//닉네임 조회
	@Override
	public String userName(String user_id) {
		// TODO Auto-generated method stub
		return dao.userName(session,user_id);
	}

	//insert게시물 번호 조회
	@Override
	public int addPostSelect(String user_id) {
		// TODO Auto-generated method stub
		return dao.addPostSelect(session,user_id);
	}

	

}
