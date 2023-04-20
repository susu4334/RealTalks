package com.reeltalks.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reeltalks.dao.MainDAO;
import com.reeltalks.dto.BoxOfficeDTO;
import com.reeltalks.dto.HotMovieDTO;
import com.reeltalks.dto.HotPostDTO;

@Service
public class MainServiceImp implements MainService {
	@Autowired
	MainDAO dao;

	@Autowired
	SqlSessionTemplate session;

	// 박스오피스 데이터 가져오기
	@Override
	public List<BoxOfficeDTO> selectBoxOffice() {
		// TODO Auto-generated method stub
		return dao.selectBoxOffice(session);
	}
	
	// 떠오르는 영화 데이터 가져오기
	@Override
	public List<HotMovieDTO> selectHotMoive(int day) {
		// TODO Auto-generated method stub
		return dao.selectHotMoive(session, day);
	}

	// 떠오르는 게시물 데이터 가져오기	
	@Override
	public List<HotPostDTO> selectHotPost(int day) {
		// TODO Auto-generated method stub
		return dao.selectHotPost(session, day);
	}

}
