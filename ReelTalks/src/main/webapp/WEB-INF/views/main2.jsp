<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
$(function(){
	
	$("#z").on("click",function(){
		
		$.ajax({
			url:'/api/movie/movieid1/post',
			type:'get',
			dataType:'text',
			headers:{
				"Content-Type":"application/json" 
			 },
			 data:{  //controller로 보낼 값
					'post_id':'6'
				},
			success:function(data,status,xhr){
				console.log(data); //data:controller에서 return값
			},
			error:function(xhr,status,error){
				
			}
			
		})
	})
})
</script>
</head>
<body>
	main.jsp<br>
<button id="z">버튼</button>

<form action="/api/movie/movieid1/post" method="post">
<!-- <input type="hidden" name="movie_id" value="movieid1"> -->
<input type="hidden" name="user_id" value="userid1">

<input type="text" name="post_title" value="title1">
<input type="text" name="content" value="content1">
<input type="text" name="star_rate" value="3">
<input type="submit" value="제출"> 
</form>

<form action="/api/movie/movieid1/post" method="get">
<input type="text" name="post_id" value="6">
<input type="submit" value="test조회"> 
</form>
</body>
</html>