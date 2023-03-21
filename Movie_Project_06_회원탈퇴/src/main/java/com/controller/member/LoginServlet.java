package com.controller.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.MemberDTO;
import com.service.MemberService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();

		// 1. 데이터 파싱
		String userid = request.getParameter("userid");
		String passwd = request.getParameter("passwd");
		
		
		
		//아이디 저장
		String rememberID = request.getParameter("rememberID");
		System.out.println(rememberID);
		

		HashMap<String, String> map = new HashMap<String, String>();
		map.put("userid", userid);
		map.put("passwd", passwd);

		MemberService service = new MemberService();
		MemberDTO dto = service.login(map);
		System.out.println("로그인 정보: " + dto);
		
		
		
		String nextPage = null;
		
		if (dto != null) { // 인증완료
			nextPage = "main.jsp";
			
			
			
			//1. 로그인성공시 alert창 출력
			String username = dto.getUsername();
			

			// 로그인성공시 top.jsp에서 화면이 바뀌는 코드
			session.setAttribute("login", dto); // 인증정보 저장 후 회원전용 페이지에서 활용
			session.setMaxInactiveInterval(60 * 60);
			
			//2. 로그인성공시 alert창 출력
			session.setAttribute("memberAdd", username + " 님 환영합니다");
			session.setMaxInactiveInterval(60*30);
			
			
			//아이디 저장체크박스
			if (rememberID != null) {
				Cookie c = new Cookie("rememberID", userid);	//쿠키 객체 생성
				c.setMaxAge(60 * 60); //60 * 60시간 동안 저장
				response.addCookie(c);
			}else {
				Cookie c = new Cookie("rememberID", userid);
				c.setMaxAge(0);
				response.addCookie(c);
			}
			

		} else { // 회원이 아닌경우

			nextPage = "LoginUIServlet"; // loginForm.jsp로 이동
			
			//로그인 실패시 경고창
			session = request.getSession();
			session.setAttribute("login_mesg", "아이디와 비밀번호를 다시 입력해주세요.");
			
			
		}

		response.sendRedirect(nextPage);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
