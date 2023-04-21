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

	@Autowired
	MainService service;
	@Autowired
	StatService sService;
	
	@GetMapping("main")
	public MainDTO main() {
		MainDTO dto = new MainDTO();
		// 일간 각 영화의 게시물 개수
		dto.setPost(sService.selectPost(1));
		// 일간 각 영화의 댓글 개수		
		dto.setReply(sService.selectReply(1));
		// 월간 카테고리별 게시물 + 댓글  개수		
		dto.setGenre(sService.selectGenre(31));
		
		// 박스 오피스
		dto.setBoxOffice(service.selectBoxOffice());
		// 떠오르는 영화
		dto.setHotMovie(service.selectHotMoive(14));
		// 떠오르는 게시물
		dto.setHotPost(service.selectHotPost(14));
		
		System.out.println(dto);
		
		return dto;
	}

	

	@GetMapping("/mainContents")
	public MainContentsDTO mainContents() {

		MainContentsDTO dto = new MainContentsDTO();

		// 박스 오피스
		dto.setBoxOffice(service.selectBoxOffice());
		// 떠오르는 영화
		dto.setHotMovie(service.selectHotMoive(14));
		// 떠오르는 게시물
		dto.setHotPost(service.selectHotPost(14));

		System.out.println("MAIN API");
		System.out.println(dto);

		return dto;
	}

	@GetMapping("/boxOffice")
	public List<BoxOfficeDTO> mainBoxOffice() {

		List<BoxOfficeDTO> list = new ArrayList<BoxOfficeDTO>();

		list = service.selectBoxOffice();

		System.out.println("BOXOFFICE API");
		System.out.println(list);

		return list;
	}

	@GetMapping("/hotMovie/{day}")
	public List<HotMovieDTO> hotMovie(@PathVariable("day") int day) {

		List<HotMovieDTO> list = service.selectHotMoive(day);

		System.out.println("HOTMOVIE API");
		System.out.println(list);

		return list;

	}
	
	@GetMapping("/hotPost/{day}")
	public List<HotPostDTO> hotPost(@PathVariable("day") int day) {
		
		List<HotPostDTO> list = service.selectHotPost(day);
			
		System.out.println("HOTPOST API");
		System.out.println(list);
		
		return list;
		
	}

}
