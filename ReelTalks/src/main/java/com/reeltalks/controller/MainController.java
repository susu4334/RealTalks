package com.reeltalks.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.reeltalks.dto.BoxOfficeDTO;
import com.reeltalks.dto.HotMovieDTO;
import com.reeltalks.dto.HotPostDTO;
import com.reeltalks.dto.MainContentsDTO;
import com.reeltalks.dto.MainDTO;
import com.reeltalks.service.MainService;
import com.reeltalks.service.StatService;

@RestController
public class MainController {
	
	// API 한 번 호출로 모든 데이터를 보내거나, 각 API로 데이터를 받아오기 위해서
	// 모든 데이터 처리는 DAOimp에서 진행하였습니다.

	@Autowired
	MainService service;
	@Autowired
	StatService sService;
	
	// 영화별 게시물 개수, 영화별 댓글 개수, 카테고리별 게시물 + 댓글 개수
	// 박스 오피스, 떠오르는 영화, 떠오르는 게시물
	@GetMapping("main")
	public MainDTO main() {
		MainDTO dto = new MainDTO();
		// 일간 각 영화의 게시물 개수
		dto.setPost(sService.selectPostFIX());
		// 일간 각 영화의 댓글 개수		
		dto.setReply(sService.selectReplyFIX());
		// 월간 카테고리별 게시물 + 댓글  개수		
		dto.setGenre(sService.selectGenreFIX());
		
		// 박스 오피스
		dto.setBoxOffice(service.selectBoxOffice());
		// 떠오르는 영화
		dto.setHotMovie(service.selectHotMoiveFIX());
		// 떠오르는 게시물
		dto.setHotPost(service.selectHotPostFIX());
		
		System.out.println(dto);
		
		return dto;
	}

	
	// 박스 오피스, 떠오르는 영화, 떠오르는 게시물 
	@GetMapping("/mainContents")
	public MainContentsDTO mainContents() {

		MainContentsDTO dto = new MainContentsDTO();

		// 박스 오피스
		dto.setBoxOffice(service.selectBoxOffice());
		// 떠오르는 영화
		dto.setHotMovie(service.selectHotMoiveFIX());
		// 떠오르는 게시물
		dto.setHotPost(service.selectHotPostFIX());

		System.out.println("MAIN API");
		System.out.println(dto);

		return dto;
	}

	// 박스 오피스
	@GetMapping("/boxOffice")
	public List<BoxOfficeDTO> mainBoxOffice() {

		List<BoxOfficeDTO> list = new ArrayList<BoxOfficeDTO>();

		list = service.selectBoxOffice();

		System.out.println("BOXOFFICE API");
		System.out.println(list);

		return list;
	}

	// 떠오르는 영화
	@GetMapping("/hotMovie/{day}")
	public List<HotMovieDTO> hotMovie(@PathVariable("day") int day) {

		List<HotMovieDTO> list = service.selectHotMoive(day);

		System.out.println("HOTMOVIE API");
		System.out.println(list);

		return list;

	}
	
	// 떠오르는 게시물
	@GetMapping("/hotPost/{day}")
	public List<HotPostDTO> hotPost(@PathVariable("day") int day) {
		
		List<HotPostDTO> list = service.selectHotPost(day);
			
		System.out.println("HOTPOST API");
		System.out.println(list);
		
		return list;
		
	}

}
