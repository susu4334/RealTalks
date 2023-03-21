<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
   request.setCharacterEncoding("UTF-8");
   String session_no = (String)session.getAttribute("session_no");
  
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 
<header>
  <h1>Acorn Cinema</h1>
</header>
<%@ include file="top.jsp" %>
<nav role="navigation">
  <ul id="main-menu">
    <li><a href="movieList.jsp">영화목록</a>
    </li>
    <li><a href="movieDate.jsp">상영일정</a>
    </li>
    <li><a href="ticketList.jsp">영화예매</a>
    </li>
    <li><a href="subItem.jsp">서브상품구매</a>
 	</li>
 </ul>
</nav>

</body>
</html>