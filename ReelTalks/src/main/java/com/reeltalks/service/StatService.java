package com.reeltalks.service;

import java.util.List;

import com.reeltalks.dto.StatDTO;
import com.reeltalks.dto.StatListDTO;

public interface StatService {

	// 영화별 기간별 게시물 개수
	public abstract List<StatDTO> selectPost(int day);

	// 각 영화의 기간별 댓글 개수
	public abstract List<StatDTO> selectReply(int day);

	// 장르별 월간 게시물 + 댓글 개수
	public abstract List<StatDTO> selectGenre(int day);
	
	// FIX 
	// 영화별 기간별 게시물 개수 고정
	public abstract List<StatDTO> selectPostFIX();
		
	// 각 영화의 기간별 댓글 개수 고정
	public abstract List<StatDTO> selectReplyFIX();

	// 장르별 월간 게시물 + 댓글 개수 고정
	public abstract List<StatDTO> selectGenreFIX();

}
