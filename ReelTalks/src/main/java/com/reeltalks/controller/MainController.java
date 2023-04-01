package com.reeltalks.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	@RequestMapping("/")
	public String main() {
		System.out.println("main.jsp 불러오기");
		return "main.jsp";
	}
}
