package com.reeltalks.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.reeltalks.dto.StatDTO;
import com.reeltalks.dto.StatListDTO;

@Repository
public class StatDAOImp implements StatDAO {

	// 각 영화의 기간별 게시물 개수 가져오기
	@Override
	public List<StatDTO> selectPost(SqlSessionTemplate session, int day) {
		// TODO Auto-generated method stub
		return session.selectList("StatMapper.selectPost", day);
	}

	// 각 영화의 기간별 댓글 개수 가져오기
	@Override
	public List<StatDTO> selectReply(SqlSessionTemplate session, int day) {
		// TODO Auto-generated method stub
		return session.selectList("StatMapper.selectReply", day);
	}

	// 장르별 월간 게시물 + 댓글 개수 가져오기
	@Override
	public List<StatDTO> selectGenre(SqlSessionTemplate session, int day) {
		// TODO Auto-generated method stub
		return session.selectList("StatMapper.selectGenre", day);
	}

}
