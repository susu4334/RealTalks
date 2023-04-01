package com.reeltalks.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reeltalks.dto.AwesomeDTO;
import com.reeltalks.service.AwesomeService;

@RestController
public class AwesomeController {
	@Autowired
	AwesomeService service;
	
	@GetMapping("/api/awesome")
	public List<AwesomeDTO> awesomeGet() {
		List<AwesomeDTO> dto = service.selectList();
		return dto;
	}
	
	@PostMapping("/api/awesome")
	public String awesomeSet() {
		
		
		return "";
	}
	
}
