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
import com.reeltalks.dto.MainListDTO;
import com.reeltalks.service.MainService;

@RestController
public class MainController {

	@Autowired
	MainService service;

	@GetMapping("/mainPage")
	public MainListDTO main() {

		MainListDTO dto = new MainListDTO();

		dto.setBoxOffice(service.selectBoxOffice());
		dto.setHotMovie(service.selectHotMoive(14));
		dto.setHotPost(service.selectHotPost(14));

		System.out.println("MAIN API");
		System.out.println(dto);

		return dto;
	}

	@GetMapping("/mainBoxOffice")
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
