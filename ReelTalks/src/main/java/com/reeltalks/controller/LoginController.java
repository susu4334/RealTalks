package com.reeltalks.controller;

import java.time.LocalDateTime;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.reeltalks.dto.UserDTO;
import com.reeltalks.login.GoogleAuth;
import com.reeltalks.login.JwtDecoder;
import com.reeltalks.securecode.SecureCode;
import com.reeltalks.service.UserService;

@Controller
public class LoginController {
	@Autowired
	UserService service;
	@Autowired
    private JwtDecoder jwtDecoder;
	
	// 회원등록(Post)
	@ResponseBody
	@PostMapping("/signup")
	public String signup(@RequestParam("user_id") String user_id, String user_name) {
		
		UserDTO dto = 
				new UserDTO(user_id, user_name, LocalDateTime.now(), LocalDateTime.now());
		int result = service.insert(dto);
		if (result == 1) {
			return "true";
		} else {
			return "false";
		}
	}
	
	// 닉네임 중복 검사
	@ResponseBody
	@GetMapping("/signup/{user_name}")
	public String username_check(@PathVariable("user_name") String user_name) {
		UserDTO dto = service.user_name_check(user_name);
		if (dto != null) {
			// 닉네임이 중복될 경우
			return "true";
		} else {
			// 닉네임이 중복안될 경우
			return "false";
		}
	}
	
	// [회원가입] 구글 창으로 조회 
	@PostMapping("/googleSignUp")
    public String googleSignUp(@RequestParam("credential") String jwt, Model m) {
    	GoogleAuth auth = new GoogleAuth();
        auth = jwtDecoder.decode(jwt, GoogleAuth.class);
        
        String email = auth.getEmail().split("@")[0];
        UserDTO dto = service.user_id_check(email);
        
        if (dto != null) {
        	// 이미 가입이 되어있는 경우
        	m.addAttribute("alarm", "이미 가입한 구글 계정입니다.");
        } else {
        	// 가입이 가능한 경우
        	m.addAttribute("user_id", email);
        }
        return "sessionSignUpCheck";
    }
	
	// [로그인] 구글 창으로 조회
	@PostMapping("/googleLogin")
    public String googleLogin(@RequestParam("credential") String jwt, Model m, HttpSession session, HttpServletResponse response) {
		GoogleAuth auth = new GoogleAuth();
        auth = jwtDecoder.decode(jwt, GoogleAuth.class);
        
        String email = auth.getEmail().split("@")[0];
        UserDTO dto = service.user_id_check(email);
        if (dto != null) {
        	// 회원 정보가 있는 경우
        	SecureCode secure = new SecureCode();
        	String[] encryptedData = secure.encode(auth.getJti());
        	
    	    m.addAttribute("key1", encryptedData[0]);
    	    m.addAttribute("key2", encryptedData[1]);
    	    
        	session.setAttribute("auth" + encryptedData[0], auth);
        } else {
        	// 회원 정보가 없는 경우
        }
        return "sessionLoginCheck";
    }
}
