package com.reeltalks.controller;

import java.util.Arrays;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.reeltalks.dto.UserDTO;
import com.reeltalks.login.GoogleAuth;
import com.reeltalks.securecode.SecureCode;
import com.reeltalks.service.UserService;

@Controller
public class CookieController {
	@Autowired
	SecureCode secure;
	@Autowired
	UserService service;

	// 회원가입할때 토큰 확인작업
	@ResponseBody
	@PostMapping("/session/{key1}/{key2}")
	public UserDTO session(@PathVariable("key1") String key1, @PathVariable("key2") String key2, HttpSession session) {
		
		GoogleAuth auth = (GoogleAuth) session.getAttribute("auth" + key1);
		System.out.println("///////////!!!!////");
		System.out.println(auth);
		System.out.println(key1);
		System.out.println(key2);
		
		String[] encryptedData = {key1, key2};
		String[] encryptedData2 = secure.encode(auth.getJti());
		
		if (Arrays.equals(encryptedData, encryptedData2)) {
			System.out.println("둘이 일치함!!!!!");
			// 만약 둘이 같으면 UserDTO 를 전달
			System.out.println(auth.getEmail());
			System.out.println(auth.getEmail().split("@")[0]);
			UserDTO dto = service.user_id_check(auth.getEmail().split("@")[0]);
			System.out.println(dto);
			return dto;
		} else {
			return null;
		}
	}
	
	// 로그인할때 + 로그인 중일때 글 등록/수정/삭제 할때 확인하는 작업
	@ResponseBody
	@PostMapping("/session/auth/{key1}/{key2}")
	public String session_check(@PathVariable("key1") String key1, @PathVariable("key2") String key2, HttpSession session) {
	
		GoogleAuth auth = (GoogleAuth) session.getAttribute("auth" + key1);
		
		String[] encryptedData = {key1, key2};
		String[] encryptedData2 = secure.encode(auth.getJti());
		
		if (Arrays.equals(encryptedData, encryptedData2)) {
			// 만약 둘이 같으면  true 리턴
			return "true";
		} else {
			return "false";
		}
	}

}
