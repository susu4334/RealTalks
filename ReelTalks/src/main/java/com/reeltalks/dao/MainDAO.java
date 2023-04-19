package com.reeltalks.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.reeltalks.dto.BoxOfficeDTO;
import com.reeltalks.dto.HotMovieDTO;
import com.reeltalks.dto.HotPostDTO;

public interface MainDAO {

	// 박스 오피스 데이터 가져오기
	public abstract List<BoxOfficeDTO> selectBoxOffice(SqlSessionTemplate session);

	// 떠오르는 영화 데이터 가져오기	
	public abstract List<HotMovieDTO> selectHotMoive(SqlSessionTemplate session, int day);

	// 떠오르는 게시물 데이터 가져오기	
	public abstract List<HotPostDTO> selectHotPost(SqlSessionTemplate session, int day);

}
