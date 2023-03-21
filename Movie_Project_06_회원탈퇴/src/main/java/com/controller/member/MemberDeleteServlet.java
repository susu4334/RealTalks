package com.controller.member;

import java.io.IOException;
import java.io.PrintWriter;

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
 * Servlet implementation class MemberDeleteServlet
 */
@WebServlet("/MemberDeleteServlet")
public class MemberDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 로그인 dto에 저장되있는 회원정보를 session으로 불러오기
		HttpSession session = request.getSession();
		MemberDTO dto = (MemberDTO) session.getAttribute("login");
		
		String nextPage = null;
		
		if (dto != null) {	//로그인 정보가 있을시 실행되는 코드
			
			request.setCharacterEncoding("utf-8");	//한글처리
			
			//1. 데이터 파싱
			String username = request.getParameter("name");
			String userid = request.getParameter("userid");
			String passwd = request.getParameter("delete_pw");	//mypage.jsp에서 form2의 패스워드 name값이 delete_pw 임으로 delete_pw로 파싱하여야 한다.
			String ybirth = request.getParameter("yy");
			String mbirth = request.getParameter("mm");
			String dbirth = request.getParameter("dd");
			String gender = request.getParameter("gender");	
			String email = request.getParameter("email");
			String phone = request.getParameter("mobile");
			
			System.out.println("userid : " + userid);
	
			MemberDTO dto2 = new MemberDTO(0, username, userid, passwd, ybirth, mbirth, dbirth, gender, email, phone);
			
			
			System.out.println("삭제할 유저정보: " + dto2);
			
			MemberService service = new MemberService();
			int n = service.memberDelete(dto2);
			System.out.println("delete record: " + n);
			
			if (n == 1) {
				
				session.invalidate(); // 삭제했다면 세션정보를 삭제한다.
				
				
				response.setCharacterEncoding("UTF-8");
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>alert('회원 탈퇴 완료.');</script>");
				out.flush();
			
//				session.setAttribute("memberDelete", "회원 탈퇴 완료.");
//				session.setMaxInactiveInterval(60*30);
				
				
				nextPage = "main";	//성공시 main화면으로
				
			}
//			if (n == 0) {
//				session.setAttribute("c_memberDelete", "비밀번호를 다시확인해주세요.");
//				session.setMaxInactiveInterval(60*30);
//				nextPage = "MyPageServlet";
//			}
//			
			
		} else {
			session.setAttribute("memberdelete_mesg", "로그인이 필요한 작업입니다.");
			nextPage = "LoginUIServlet";
		}
		
		response.sendRedirect("main.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
