package com.reeltalks.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.reeltalks.dto.StatDTO;
import com.reeltalks.dto.StatListDTO;

public interface StatDAO {
	
	// 모든 통계 데이터 가져오기
	public abstract StatListDTO selectStat(SqlSessionTemplate session);

	// 각 영화의 기간별 게시물 개수 가져오기	
	public abstract List<StatDTO> selectPost(SqlSessionTemplate session, int day);

	// 각 영화의 기간별 댓글 개수 가져오기	
	public abstract List<StatDTO> selectReply(SqlSessionTemplate session, int day);

	// 장르별 월간 게시물 + 댓글 개수 가져오기	
	public abstract List<StatDTO> selectGenre(SqlSessionTemplate session, int day);


}
