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
import com.reeltalks.service.UserService;

@Controller
public class LoginController {
	@Autowired
	UserService service;
	@Autowired
    private JwtDecoder jwtDecoder;
	
	// 로그인 화면 조회
	@GetMapping("/login")
	public String login() {
		System.out.println("login.jsp 불러오기");
		return "googleLogin.jsp";
	}
	
	// 구글로그인 창으로 조회
	@GetMapping("/googleSignup")
	public String googleLogin() {
		System.out.println("googleLogin.jsp 불러오기");
		return "googleSignup.jsp";
	}
	
	// 회원등록(Post)
	@PostMapping("/signup")
	public String signup(@RequestParam("user_id") String user_id, String user_name) {
		
		UserDTO dto = 
				new UserDTO(user_id, user_name, LocalDateTime.now(), LocalDateTime.now());
		System.out.println(dto);
		service.insert(dto);
		
		return "main.jsp";
	}
	
	// 닉네임 중복 검사
	@ResponseBody
	@GetMapping("/signup/{user_name}")
	public String username_check(@PathVariable("user_name") String user_name) {
		System.out.println("받았음!!!!!!!!!!!!!!!!!!!!!!!");
		UserDTO dto = service.user_name_check(user_name);
		if (dto != null) {
			System.out.println("닉네임이 중복됩니다.");
			return "true";
		} else {
			System.out.println("사용가능한 닉네임 입니다.");
			return "false";
		}
	}
	
	// [회원가입] 구글로그인 창으로 조회 
	@PostMapping("/googleSignUp")
    public String googleSignUp(@RequestParam("credential") String jwt, HttpSession session) {
    	GoogleAuth auth = new GoogleAuth();
        auth = jwtDecoder.decode(jwt, GoogleAuth.class);
        System.out.println(auth);
        
        // email 만 받아와서 db에서 체크
        String email = auth.getEmail().split("@")[0];
        UserDTO dto = service.user_id_check(email);
        
        if (dto != null) {
        	System.out.println("이미 가입한 구글계정입니다.");
        	session.setAttribute("alarm", "이미 가입한 구글 계정입니다.");
        } else {
        	System.out.println("가입을 진행해주세요!");
        	session.setAttribute("user_id", email);
        }
        return "sessionSIgnUpCheck.jsp";
    }
	
	// 구글로그인 창으로 조회
	@PostMapping("/googleLogin")
    public String googleLogin(@RequestParam("credential") String jwt, Model m, HttpSession session, HttpServletResponse response) {
    	GoogleAuth auth = new GoogleAuth();
        auth = jwtDecoder.decode(jwt, GoogleAuth.class);
        System.out.println("jti 확인");
        System.out.println(auth.getJti());
        
        String email = auth.getEmail().split("@")[0];
        UserDTO dto = service.user_id_check(email);
        if (dto != null) {
        	System.out.println("알림창: 회원 정보가 있습니다.");
        	System.out.println(dto);
        	
//    	    Cookie token_id = new Cookie("token_id", auth.getJti());
//    	    // 30초 후 만료됩니다.
//    	    token_id.setMaxAge(30);
//    	    token_id.setHttpOnly(true);
//    	    token_id.setSecure(true);
//    	    response.addCookie(token_id);
    	    
    	    // 여기서 부턴 test 작업
    	    //response.
    	    
    	    

    	    // 생성된 쿠키를 HttpSession에 저장합니다.
        	session.setAttribute("jti_id", auth.getJti());
    	    //session.setAttribute("token_id", token_id.getValue());
//    	    session.setAttribute("cookie_id", token_id);
    	    //session.setMaxInactiveInterval("30");
    	    //System.out.println("세션 등록이 완료되었습니다.");
    	    
    	    m.addAttribute("user_id", dto.getUser_id());
        } 
        return "sessionLoginCheck.jsp";
        // 만약 비동기 처리로 json 타입으로 넘기게 된다면 return dto 하면됨
    }
}