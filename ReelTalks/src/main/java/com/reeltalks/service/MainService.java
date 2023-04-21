package com.reeltalks.service;

import java.util.List;

import com.reeltalks.dto.BoxOfficeDBDTO;
import com.reeltalks.dto.BoxOfficeDTO;
import com.reeltalks.dto.HotMovieDTO;
import com.reeltalks.dto.HotPostDTO;

public interface MainService {
	
	// boxOffice 데이터 가져오기
	public abstract List<BoxOfficeDTO> selectBoxOffice();
	
	// hotMoive 데이터 가져오기
	public abstract List<HotMovieDTO> selectHotMoive(int day);
	
	// hotPost 데이터 가져오기
	public abstract List<HotPostDTO> selectHotPost(int day);
	
	// FIX
	// hotMoive 데이터 가져오기 고정
	public abstract List<HotMovieDTO> selectHotMoiveFIX();
		
	// hotPost 데이터 가져오기
	public abstract List<HotPostDTO> selectHotPostFIX();

}
