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
	
	@Autowired
	StatService service;
	
	@GetMapping("/statistics")
	public StatListDTO statistics() {
		
		StatListDTO dto = new StatListDTO();
		// 일간 각 영화의 게시물 개수
		dto.setPost(service.selectPost(1));
		// 일간 각 영화의 댓글 개수		
		dto.setReply(service.selectReply(1));
		// 월간 카테고리별 게시물 + 댓글  개수		
		dto.setGenre(service.selectGenre(31));
		System.out.println(dto);
		return dto;
	}
	
	@GetMapping("/statisticsPost/{day}")
	public List<StatDTO> statisticsPost(@PathVariable("day") int day) {
		
		List<StatDTO> list = service.selectPost(day);
		System.out.println(day + "일간 각 영화의 게시물의 개수");
		System.out.println(list);
		return list;
	}
	
	@GetMapping("/statisticsReply/{day}")
	public List<StatDTO> statisticsReply(@PathVariable("day") int day) {
		
		List<StatDTO> list = service.selectReply(day);
		System.out.println(day + "일간 각 영화의 댓글의 개수");
		System.out.println(list);
		return list;
	}
	
	@GetMapping("/statisticsGenre/{day}")
	public List<StatDTO> statisticsGenre(@PathVariable("day") int day) {
		
		List<StatDTO> list = service.selectGenre(day);
		System.out.println("월간 카테고리 별 게시글 + 댓글의 개수");
		System.out.println(list);
		return list;
	}

}	
