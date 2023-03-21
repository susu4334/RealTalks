<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>

<!-- 스타일 시트(stylesheet)로 사용할 외부 리소스를 불러옴. -->
<link rel="stylesheet" href="css/signup.css">

</head>


<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<script type="text/javascript">
	$(document).ready(function() {

		//이름, 아이디, 패스워드, 생년월일, 이메일, 전화번호 공백시 이벤트 발생
		$("form").submit(function() {
			var name = $("#name");
			var id = $("#userid");
			var pw = $("#pswd1");
			var pw2 = $("#pswd2");
			var ybirth = $("#yy");
			var mbirth = $("#mm");
			var dbirth = $("#dd");
			var email = $("#email");
			var phone = $("#mobile");
			
			
			if (pw.val() != pw2.val()) {
				alert("비밀번호를 확인해주세요.")
				pw2.focus();
				event.preventDefault();
			}
			
			

			if (name.val().length == 0) {
				alert("이름 입력");
				name.focus();
				event.preventDefault();
			}

			if (id.val().length == 0) {
				alert("아이디 입력");
				id.focus();
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

			if (ybirth.val().length == 0) {
				alert("생년월일 입력");
				ybirth.focus();
				event.preventDefault();
			}

			if (mbirth.val().length == 0) {
				alert("생년월일 입력");
				mbirth.focus();
				event.preventDefault();
			}

			if (dbirth.val().length == 0) {
				alert("생년월일 입력");
				dbirth.focus();
				event.preventDefault();
			}

			if (email.val().length == 0) {
				alert("이메일 입력");
				email.focus();
				event.preventDefault();
			}

			if (phone.val().length == 0) {
				alert("핸드폰번호 입력");
				phone.focus();
				event.preventDefault();
			}

		});

		$("#pswd2").on("keyup", function() {

			/* var mesg = "비밀번호 일치"; */

			var pw1 = $("#pswd1").val();
			var pw2 = $("#pswd2").val();

			if (pw1 != pw2) {

				/* mesg = "비밀번호 불일치"; */

				$("#result").css("color", "red").html("비밀번호 불일치");

				console.log($("#result").css("color", "red").text("비밀번호 불일치"));
				

			} else {

				$("#result").css("color", "blue").html("비밀번호 일치");

				/* $("#result").text(mesg); */
				console.log($("#result").css("color", "blue").html("비밀번호 일치"));

			}

		});

		//아이디 중복 체크
		//비동기 처리방식
		$("#idcheck").on("click", function() {

			//ajax
			$.ajax({

				type : "get", //서버에 get/post방식 요청
				url : "MemberIdCheckServlet", //서버 요청 주소

				data : {
					userid : $("#userid").val()
				},

				dataType : "text", //응답 data 타입 text, json, xml, html

				success : function(responseData, status, xhr) { //요청에대한 응답 성공시

					//data: 응답으로 비동기 전송된 data
					console.log("success : ", responseData);

					alert(responseData);

					/* if (responseData == 1) {			
						//data: 응답으로 비동기 전송된 data
						console.log("success : ", responseData);
						 alert("사용가능한 아이디입니다.");
						 
					}else {
						 alert("아이디가 존재합니다. 다른 아이디를 입력해주세요.");
					}
					
					
					$("#result").text(responseData);//중복, 사용가능 */
				},
				error : function(xhr, status, e) { //요청에 대한 응답이 error인 경우
					console.log("e", e);
					console.log("status", status);
					console.log("xhr", xhr);
					console.log("xhr", xhr.status);

				}

			});//end ajax

		});

	});
</script>

<body>

	<form action="MemberAddServlet" method="post">
		<!-- <h1>Acorn Cinema</h1> -->
		<div id="header">
			<h1>Acorn Cinema</h1>
		</div>

		<hr>


		<div id="wrapper">

			<div id="content">

				<!-- NAME -->
				<div>
					<h3>
						<label for="name">이름</label>
					</h3>
					<span class="box int_name"> <input type="text" name="name"
						id="name" class="int" maxlength="20">
					</span>
				</div>

				<!-- ID -->
				<div>
					<h3>
						<label id="label">아이디</label>
					</h3>
					<!-- 				<span class="box_int_id"> <input type="text" id="userid"
					class="int" maxlength="20"> <input type="button"
					value="중복확인">
				</span> -->
					<input type="text" name="userid" id="userid" maxlength="20"
						style="height: 29px; font-size: 15px; border: none; padding-right: 110px;">
					<input type="button" id="idcheck" value="중복확인">

				</div>

				<!-- PW1 -->
				<div>
					<h3>
						<label for="pswd1">비밀번호</label>
					</h3>
					<span class="box int_pass"> <input type="text" name="pswd1"
						id="pswd1" class="int" maxlength="20"> <img
						src="img/m_icon_pass.png" id="pswd1_img1" class="pswdImg">
					</span>
				</div>

				<!-- PW2 -->
				<div>
					<h3 class="join_title">
						<label for="pswd2">비밀번호 재확인</label>
					</h3>
					<span class="box int_pass_check"> <input type="text"
						name="pswd2" id="pswd2" class="int" maxlength="20"> <img
						src="img/m_icon_check_disable.png" id="pswd2_img1" class="pswdImg">
					</span> <span id="result" class="error_next_box"></span>
				</div>


				<!-- BIRTH -->
				<div>
					<h3>
						<label for="yy">생년월일</label>
					</h3>

					<div id="bir_wrap">

						<!-- BIRTH_YY -->
						<div id="bir_yy">
							<span class="box"> <input type="text" name="yy" id="yy"
								class="int" maxlength="4" placeholder="년(4자)">
							</span>
						</div>

						<!-- BIRTH_MM -->
						<div id="bir_mm">
							<span class="box"> <select id="mm" name="mm" class="sel">
									<option>월</option>
									<option value="01">1</option>
									<option value="02">2</option>
									<option value="03">3</option>
									<option value="04">4</option>
									<option value="05">5</option>
									<option value="06">6</option>
									<option value="07">7</option>
									<option value="08">8</option>
									<option value="09">9</option>
									<option value="10">10</option>
									<option value="11">11</option>
									<option value="12">12</option>
							</select>
							</span>
						</div>

						<!-- BIRTH_DD -->
						<div id="bir_dd">
							<span class="box"> <input type="text" name="dd" id="dd"
								class="int" maxlength="2" placeholder="일">
							</span>
						</div>

					</div>
				</div>


				<!-- GENDER -->
				<div>
					<h3>
						<label for="gender">성별</label>
					</h3>
					<table width="100%" cellspacing="0" cellpadding="0" border="1"
						style="border-collapse: collapse" bordercolor="#CCCCCC">
						<tr>
							<td width="125" height="35" class="td_default"><input
								type="radio" name="gender" value="남" checked>남</input> <input
								type="radio" name="gender" value="여">여</input></td>
						</tr>

					</table>
				</div>

				<!-- EMAIL -->
				<div>
					<h3>
						<label for="email">본인확인 이메일<span class="optional"></span></label>
					</h3>
					<span class="box int_email"> <input type="text" name="email"
						id="email" class="int" maxlength="100"
						placeholder="ex) example@naver.com">
					</span>
				</div>


				<!-- MOBILE -->
				<div>
					<h3>
						<label for="phoneNo">휴대전화</label>
					</h3>
					<span class="box int_mobile"> <input type="tel"
						name="mobile" id="mobile" class="int" maxlength="16"
						placeholder="전화번호 입력">
					</span>
				</div>


				<!-- JOIN BTN-->
				<div class="btn_area">
					<input type="submit" id="btnJoin" value="가입하기">
				</div>


			</div>
			<!-- content -->

		</div>
		<!-- wrapper -->



	</form>

</body>
</html>