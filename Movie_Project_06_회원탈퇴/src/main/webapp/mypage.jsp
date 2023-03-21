<%@page import="com.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
MemberDTO dto = (MemberDTO) session.getAttribute("login");

String username = dto.getUsername();
String userid = dto.getUserid();
String passwd = dto.getPasswd();
String ybirth = dto.getYbirth();
String mbirth = dto.getMbirth();
String dbirth = dto.getDbirth();
String gender = dto.getGender();
String email = dto.getEmail();
String phone = dto.getPhone();
%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보수정</title>


<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">


<!-- 스타일 시트(stylesheet)로 사용할 외부 리소스를 불러옴. -->
<link rel="stylesheet" href="css/mypage.css">






<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">

	$(document).ready(function() {

		$("#form1").submit(function() {

			var pw = $("#pswd1");
			var pw2 = $("#pswd2");

			if (pw.val() != pw2.val()) {
				alert("비밀번호를 확인해주세요.")
				pw2.focus();
				event.preventDefault();
			}
			
			if (pw.val().length == 0) {
				alert("비밀번호 입력");
				pw.focus();
				event.preventDefault();
			}

			if (pw2.val().length == 0) {
				alert("비밀번호 재확인 입력");
				pw2.focus();
				event.preventDefault();
			}

		});
		
		

		
		/* 회원탈퇴폼 */
		$("#form2").submit(function() {

			var delete_pw = $("#delete_pw");
			
			if (delete_pw.val().length == 0) {
				alert("비밀번호를 입력하세요.");
				delete_pw.focus();
				event.preventDefault();
			}


		});
		
		

	});
	
	
</script>




</head>
<body class="bg-light">

	<div class="container">
		<main>

			<div class="py-5 text-center">

				<h1>Acorn Cinema</h1>

			</div>




			<!-- 부트스트랩 사용 -->
			<div class="row g-5">

				<div class="col-md-5 col-lg-4 order-md-last">
					<h4 class="d-flex justify-content-between align-items-center mb-3">
						<span class="text-primary">회원 탈퇴</span>
					</h4>
					<p>
						비밀번호 인증 성공시 모든 회원정보와 예매한 영화는 <br>환불이 불가하오니 확인 부탁드립니다.
					</p>

					<form id="form2" action="MemberDeleteServlet" method="post">

						<div>
						<!-- 해당 userid의 정보를 삭제해야 하기 때문에 userid를 hidden설정하여 데이터를 넘긴다, 그리고 value값을 받아서 다시 서블릿에 넘겨야한다. -->
						<input type="hidden" value="<%=userid %>" name="userid" id="userid">
							비밀번호 입력: <input type="text" name="delete_pw" id="delete_pw">
						</div>

						<div class="memberDelete"
							style="text-align: center; margin-top: 50px;">
							<input type="submit" class="btn btn-danger" id="btnDelete"
								value="회원탈퇴">
						</div>

					</form>

				</div>






				<div class="col-md-7 col-lg-8">

					<h4 class="d-flex justify-content-between align-items-center mb-3">
						<span class="text-primary">회원정보수정</span>
					</h4>




					<form id="form1" action="MemberUpdateServlet" method="post">


						<div class="row g-3">
							<div class="col-sm-7">
								<label for="name" class="form-label" style="font-size: 20px;">이름
									: </label><br>
								<%=username%>
							</div>
						</div>
						<br>



						<div class="col-7">
							<label for="userid" class="form-label" style="font-size: 20px;">아이디
								: </label><input type="hidden" value="<%=userid%>" id="userid"
								name="userid"><br>
							<%=userid%>
						</div>
						<br>




						<div class="col-7">
							<label for="email" class="form-label" style="font-size: 20px;">Email
								: </label><br>
							<%=email%>
						</div>
						<br>




						<div class="col-7">
							<label for="birth" class="form-label" style="font-size: 20px;">생년월일
								: </label><br>
							<%=ybirth + "년 " + mbirth + "월 " + dbirth + "일"%>
						</div>
						<br>





						<div class="col-7">
							<label for="gender" class="form-label" style="font-size: 20px;">성별
								: </label><br>
							<%=gender%>
						</div>
						<br>


						<div class="col-7">
							<label for="phone" class="form-label" style="font-size: 20px;">핸드폰
								번호 : </label><br><%=phone%>
						</div>
						<br>




						<div class="col-7">
							<label for="pswd1" class="form-label" style="font-size: 20px;">비밀번호변경
								: <span class="text-muted"></span>
							</label> <input type="password" class="form-control" id="pswd1"
								name="pswd1">
						</div>
						<br>




						<div class="col-7">
							<label for="pswd2" class="form-label" style="font-size: 20px;">비밀번호변경
								확인<span class="text-muted"></span>
							</label> <input type="password" class="form-control" id="pswd2"
								name="pswd2">
						</div>




						<hr class="my-4">

						<div class="memberUpdate" style="text-align: center;">
							<input type="submit" class="btn btn-primary btn-lg"
								id="memberUpdate" value="회원정보수정">
						</div>



					</form>
				</div>
			</div>
		</main>

	</div>






	<!-- JavaScript Bundle with Popper -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
		crossorigin="anonymous"></script>
</body>


</html>