package com.controller.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dto.MemberDTO;
import com.service.MemberService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/MemberAddServlet")
public class MemberAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//		SqlSession session = MySqlSessionFactory.getSqlSession();
//		System.out.println(session);
		
		request.setCharacterEncoding("UTF-8");
		
		//1. 데이터 파싱
		String username = request.getParameter("name");
		String userid = request.getParameter("userid");
		String passwd = request.getParameter("pswd1");
		String ybirth = request.getParameter("yy");
		String mbirth = request.getParameter("mm");
		String dbirth = request.getParameter("dd");
		String gender = request.getParameter("gender");	//getParameterValues로 name=gender의 체크박스 값을 받는다.
		String email = request.getParameter("email");
		String phone = request.getParameter("mobile");
		
//		System.out.println(username + userid + passwd + ybirth + mbirth + dbirth + gender + email + phone);
		
		//2. dto 생성
		MemberDTO dto = new MemberDTO(0, username, userid, passwd, ybirth, mbirth, dbirth, gender, email, phone);
		System.out.println(dto);
		
		//3. insert문 생성
		MemberService service = new MemberService();
		int n = service.memberAdd(dto);
		System.out.println("추가된 회원수: " + n);
		
		
		//4. main.jsp에 회원가입 성공 창 띄우기
		if (n==1) {
			HttpSession session = request.getSession();
			session.setAttribute("memberAdd", userid + " 님 회원가입 성공!");
			session.setMaxInactiveInterval(60*30);
		}
		
		response.sendRedirect("main.jsp");	//넘어갈 데이터가 없으므로 sendRedirect사용(한 화면에서 처리 한다.)
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
