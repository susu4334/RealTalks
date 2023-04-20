<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	sessionLoginCheck.jsp<br>
	${ key1 }
	${ key2 }

		<!-- 쿠키 값 읽어오기 -->
<%-- 	<%
	    Cookie[] cookies = request.getCookies();
	    String token_id = null;
	    if (cookies != null) {
	        for (Cookie cookie : cookies) {
	            if (cookie.getName().equals("token_id")) {
	                token_id = cookie.getValue();
	                break;
	            }
	        }
	    }
	%>
	
	<!-- Vue로 쿠키 값 전달하기 -->
	<script>
	    const token_id = <%= token_id != null ? "\"" + token_id + "\"" : "null" %>;
	    // token_id를 Vue 인스턴스의 data에 저장
	    <%
	    	request.setAttribute("token_id", token_id);
	    %>
	    location.href = "/login/sso/${user_id}";
	</script> --%>

	<script>
		console.log("/login/sso/${key1}/${key2}");
		location.href = "/login/sso/${key1}/${key2}";
		//location.href = "../../";
	</script>
</body>
</html>