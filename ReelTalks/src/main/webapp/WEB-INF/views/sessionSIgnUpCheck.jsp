<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
</script>
<body>
	sessionSIgnUpCheck.jsp<br>
	${ alarm }<br>
	${ user_id }<br>
	///////////////////////////////<br>



	<%
 		String alarm = (String)session.getAttribute("alarm");
		String user_id = (String)session.getAttribute("user_id");
		session.removeAttribute("alarm");	
		session.removeAttribute("user_id");
		if (user_id == null) { %>
			<!-- 회원가입이 이미 되어있을때 -->
			회원가입이 이미 되어있습니다!<br>
			<%= alarm %>
				<script>
					alert("<%=alarm%>");
					//넘겨야 되는 위치는 로그인눌렀을때 나오는 창
					//location.href = "넘겨주면되는 vue 링크" + user_id;
					location.href = "/singup";
					//location.href = "/googleLogin.jsp";
				</script>
	<%  } else { %>
		<!-- 회원 가입이 안되어있을때 (닉네임 작성 창으로 넘어감) -->
			회원가입을 진행해주세요~! (닉네임 작성 창으로!)<br>
			<%= user_id %>
			<script>
				console.log("<%=user_id%>");
				location.href = "/signup/"+"<%= user_id %>";
				//넘겨야 되는 위치는 닉네임 입력하고 중복확인하며 회원가입 진행하는 창
				//location.href = "넘겨주면되는 vue 링크" + user_id;
				//location.href = "/googleLogin.jsp";
			</script>
	<%  } %>
	
<!-- 	response.sendRedirect("/signup/" + user_id);
		pageContext.forward("/signup/" + user_id); -->
</body>
</html>