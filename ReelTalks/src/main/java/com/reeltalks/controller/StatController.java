package com.reeltalks.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.reeltalks.dto.StatDTO;
import com.reeltalks.dto.StatListDTO;
import com.reeltalks.service.StatService;

@RestController
public class StatController {
	
	// API 한 번 호출로 모든 데이터를 보내거나, 각 API로 데이터를 받아오기 위해서
	// 모든 데이터 처리는 DAOimp에서 진행하였습니다.
	
	@Autowired
	StatService service;
	
	// 영화별 게시물 개수, 영화별 댓글 개수, 카테고리 별 게시물 + 댓글 개수
	@GetMapping("/statistics")
	public StatListDTO statistics() {
		
		// 고정된 기간은 StatDAOImp에서 변경 가능
		
		StatListDTO dto = new StatListDTO();
		// 일간 각 영화의 게시물 개수
		dto.setPost(service.selectPostFIX());
		// 일간 각 영화의 댓글 개수		
		dto.setReply(service.selectReplyFIX());
		// 월간 카테고리별 게시물 + 댓글  개수		
		dto.setGenre(service.selectGenreFIX());
		return dto;
	}
	
	// 영화별 게시물 개수
	@GetMapping("/statisticsPost/{day}")
	public List<StatDTO> statisticsPost(@PathVariable("day") int day) {
		
		List<StatDTO> list = service.selectPost(day);
		return list;
	}
	
	// 영화별 댓글 개수
	@GetMapping("/statisticsReply/{day}")
	public List<StatDTO> statisticsReply(@PathVariable("day") int day) {
		
		List<StatDTO> list = service.selectReply(day);
		return list;
	}
	
	// 카테고리별 게시물 + 댓글 개수
	@GetMapping("/statisticsGenre/{day}")
	public List<StatDTO> statisticsGenre(@PathVariable("day") int day) {
		
		List<StatDTO> list = service.selectGenre(day);
		return list;
	}

}	
