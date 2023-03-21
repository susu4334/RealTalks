package com.controller.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.MemberDTO;
import com.service.MemberService;

/**
 * Servlet implementation class MemberUpdateServlet
 */
@WebServlet("/MemberUpdateServlet")
public class MemberUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		MemberDTO dto = (MemberDTO) session.getAttribute("login");
		
		String nextPage = null;
		
		if (dto != null) {
			request.setCharacterEncoding("utf-8");	//한글처리
			
			//1. 데이터 파싱
			String username = request.getParameter("name");
			String userid = request.getParameter("userid");
			String passwd = request.getParameter("pswd1");
			String ybirth = request.getParameter("yy");
			String mbirth = request.getParameter("mm");
			String dbirth = request.getParameter("dd");
			String gender = request.getParameter("gender");	
			String email = request.getParameter("email");
			String phone = request.getParameter("mobile");
			
			MemberDTO dto2 = new MemberDTO(0, username, userid, passwd, ybirth, mbirth, dbirth, gender, email, phone);
			System.out.println(dto2);
			
			MemberService service = new MemberService();
			int n = service.memberUpdate(dto2);
			System.out.println("update record: " + n);
			
			if (n == 1) {
				dto2 = service.mypage(userid);	//userid로 db에 다시 가서 최신정보를 select 해온다.
				session.setAttribute("login", dto2);	//세션에 최신정보 덮어쓰기
				session.setAttribute("memberUpdate", "회원정보 수정 완료");	//세션에 최신정보 덮어쓰기
				session.setMaxInactiveInterval(60*30);//30분
			}
			nextPage = "main";
			
			
		}else {	//로그인 실패시
			nextPage = "LoginUIServlet";
			session.setAttribute("memberupdate_mesg", "로그인이 필요한 작업입니다.");
		}
		
		RequestDispatcher dis = request.getRequestDispatcher(nextPage);
		dis.forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
