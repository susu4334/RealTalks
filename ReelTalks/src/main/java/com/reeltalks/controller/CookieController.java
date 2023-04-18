package com.reeltalks.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CookieController {

	// 최초 로그인할때 토큰 프론트로 패스해주기(session_set)
	////////////////////////////////user_id 가 필요없음!!!////////////////////////////////
	@ResponseBody
	@GetMapping("/session/{user_id}")
	public Cookie session_get(@PathVariable String user_id, HttpSession session, HttpServletResponse response) {
		
		String jti_id = (String) session.getAttribute("jti_id");
		session.removeAttribute("jti_id");
		
		System.out.println("넘어갈때!!!!!!!!!!!!!!!!:" + jti_id);
	    Cookie token_id = new Cookie("token_id", jti_id);
	    // 30초 후 만료됩니다.
	    token_id.setMaxAge(30);
	    token_id.setHttpOnly(true);
	    token_id.setSecure(true);
	    response.addCookie(token_id);

	    session.setAttribute("token_id_value", token_id.getValue());
	    //session.setAttribute("token_id", token_id.getValue());
	    //session.setAttribute("cookie_id", token_id);
	    System.out.println("세션 등록이 완료되었습니다.");
		
		// 쿠키 session 에서 뽑아옴
//		String token_id = (String) session.getAttribute("token_id");
//	    System.out.println(token_id);
	    
	    // 뽑아서 전달했으니 "token_id" session 값을지움
	    //session.removeAttribute("token_id");
    	return token_id;
	}
	
	// 로그인 토큰 확인작업
	@ResponseBody
	@GetMapping("/session")
	public String session_check(@RequestParam("token_id") String token_id, HttpSession session) {
		// true면 진행해라!!(둘의 token값이 같음), false면 진행하지마라!!(둘의 token값이 다름)
		if (token_id != null) {
			String session_token_id = ((Cookie) session.getAttribute("cookie_id")).getValue();
			if (token_id.equals(session_token_id)) {
				return "true";
			} else {
				return "false";
			}
		} else {
			
			return "false";
		}
	}

}
