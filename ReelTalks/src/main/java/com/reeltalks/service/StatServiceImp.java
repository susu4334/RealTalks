package com.reeltalks.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reeltalks.dao.StatDAO;
import com.reeltalks.dto.StatDTO;
import com.reeltalks.dto.StatListDTO;

@Service
public class StatServiceImp implements StatService {
	@Autowired
	StatDAO dao;

	@Autowired
	SqlSessionTemplate session;

	// 모든 통계 데이터 가져오기
	@Override
	public StatListDTO selectStat() {
		return dao.selectStat(session);
	}

	// 각 영화의 기간별 게시물 개수 가져오기
	@Override
	public List<StatDTO> selectPost(int day) {
		return dao.selectPost(session, day);
	}

	// 영화별 일간 댓글 개수 가져오기
	@Override
	public List<StatDTO> selectReply(int day) {
		return dao.selectReply(session, day);
	}

	// 장르별 월간 게시물 + 댓글 개수 가져오기
	@Override
	public List<StatDTO> selectGenre(int day) {
		return dao.selectGenre(session, day);
	}

}
