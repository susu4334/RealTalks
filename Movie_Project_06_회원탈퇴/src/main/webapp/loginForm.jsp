<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- 스타일 시트(stylesheet)로 사용할 외부 리소스를 불러옴. -->
<link rel="stylesheet" href="css/login.css">







<!-- MyPageServlet 주소만 입력하고 넘어갈 경우 회원요청 -->
<%
String mypage_mesg = (String) session.getAttribute("mypage_mesg");
if (mypage_mesg != null) {
%>
<script type="text/javascript">
	alert("<%=mypage_mesg%>");
</script>

<%
session.removeAttribute("mypage_mesg");
}
%>



<!-- MemberUpdateServlet 주소만 입력하고 넘어갈 경우 회원요청 -->
<%
String memberupdate_mesg = (String) session.getAttribute("memberupdate_mesg");
if (memberupdate_mesg != null) {
%>
<script type="text/javascript">
	alert("<%=memberupdate_mesg%>");
</script>

<%
session.removeAttribute("memberupdate_mesg");
}
%>



<!-- MemberDeleteServlet 주소만 입력하고 넘어갈 경우 회원요청 -->
<%
String memberdelete_mesg = (String) session.getAttribute("memberdelete_mesg");
if (memberdelete_mesg != null) {
%>
<script type="text/javascript">
	alert("<%=memberdelete_mesg%>");
</script>

<%
session.removeAttribute("memberdelete_mesg");
}
%>





<!-- 로그인 실패했을경우 -->
<%
String login_mesg = (String) session.getAttribute("login_mesg");
if (login_mesg != null) {
%>
<script type="text/javascript">
	alert("<%=login_mesg%>");
</script>

<%
session.removeAttribute("login_mesg");
}
%>





<!-- 로그인 성했을경우 -->
<%
String memberAdd = (String) session.getAttribute("memberAdd");
if (memberAdd != null) {
%>
<script type="text/javascript">
	alert("<%=memberAdd%>
	");
</script>

<%
session.removeAttribute("memberAdd");
}
%>








<!-- 아이디 체크 저장 -->
<%
Cookie[] c = request.getCookies();
String cookieVal = "";
if (c != null) {
	for (Cookie i : c) {
		if (i.getName().equals("rememberID")) {
	cookieVal = i.getValue();
		}
	}
}
%>



</head>

<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<script type="text/javascript">
	$(document).ready(function() {

		$("form").submit(function() {

			if ($("#userid").val().length == 0) {

				alert("아이디값을 입력하시오");
				$("#userid").focus();
				event.preventDefault();

			} else if ($("#passwd").val().length == 0) {

				alert("비밀번호값을 입력하시오");
				$("#passwd").focus();
				event.preventDefault();
			}
		});

	});
</script>



<body>

	<form action="LoginServlet" method="get">

		<div id="header">
			<h1>로그인</h1>
		</div>

		<div id="wrapper">

			<div id="content">


				<!-- userid -->
				<div>
					<span class="box int_userid"> <input type="text" id="userid"
						name="userid" value="<%=cookieVal != "" ? cookieVal : ""%>"
						class="int" maxlength="20" placeholder="아이디">
					</span>
				</div>



				<!-- password -->
				<div>
					<span class="box int_password"> <input type="text"
						id="passwd" name="passwd" class="int" maxlength="20"
						placeholder="비밀번호">
					</span>
				</div>


				<!-- checkBox -->
				<div class="check">
					<input type="checkbox" id="rememberID" name="rememberID"
						<%=cookieVal != "" ? "checked" : ""%>
						style="width: 25px; height: 25px;">아이디 저장
				</div>


				<!-- login btn -->
				<div class="btn_area">
					<input type="submit" id="btnLogin" value="로그인"></input>
				</div>


				<!-- 링크연결 -->
				<div class="link">
					<a href="">ID/PW 찾기</a>&nbsp&nbsp&nbsp&nbsp&nbsp <a
						href="siginupForm.jsp">회원가입</a>&nbsp&nbsp&nbsp&nbsp&nbsp <a
						href="">비회원 예매 확인</a>
				</div>


			</div>

		</div>

	</form>



</body>
</html>