<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.net.*, java.io.*"%>
    <%@page import="org.json.simple.parser.*"%>
    <%@page import="org.json.simple.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
movie 검색<br>
<form action="movieadd" method="get">
	<input type="text" name="title">
	<input type="submit" value="검색">
</form><br>
가져 와야 할것 : 영화 이미지(완), 영화명(완), 개봉일(완), 카테고리(완), 영화id(완), 줄거리(완), 주연(완), 감독(완), 등급(완)
<br>
<br>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script> 
<script type="text/javascript">
	
	function madd(docid){
		$("#movietitle"+docid).on("click", function(){
			$("#movieform"+docid).submit();
		});
	}

</script>

<% 
	String allData = (String)request.getAttribute("allData"); 
	
	JSONParser jsonParser = new JSONParser();
    JSONObject jsonObject = (JSONObject)jsonParser.parse(allData);
    
    int totalcount = Integer.parseInt(String.valueOf(jsonObject.get("TotalCount")));
 	System.out.println("totalcount : "+totalcount);
 	
 	if(totalcount==0){ 
	 	response.setContentType("text/html;charset=UTF-8");
	 	PrintWriter out2 = response.getWriter();
	 	out2.println("<script>");
	 	out2.println("alert('존재하지 않는 영화 입니다.');");
	 	out2.println("location.href='movieadd';");
	 	out2.println("</script>");
 		return;
 	}  
 	
 	
 	JSONArray movieDataArr = (JSONArray)jsonObject.get("Data");
 	JSONObject movieJson= (JSONObject)movieDataArr.get(0);
 	JSONArray movieResultArr = (JSONArray)movieJson.get("Result");
 	
 	for(int i = 0; i<= movieResultArr.size()-1; i++){
 	JSONObject ResultJson= (JSONObject)movieResultArr.get(i);
 	
 	String title = (String)ResultJson.get("title");
 	String title2 = title.replace("!HS", "");
 	String title3 = title2.replace("!HE", "");
 	
 	String poster = (String)ResultJson.get("posters");
 	String[] posterArr = poster.split("\\|");
 	String realposter = posterArr[0];
 	
 	String genre = (String)ResultJson.get("genre");
 	String DOCID = (String)ResultJson.get("DOCID");
 	String repRlsDate = (String)ResultJson.get("repRlsDate");
 	String rating = (String)ResultJson.get("rating");
 	
 	JSONObject plots= (JSONObject)ResultJson.get("plots");
 	JSONArray movieplotArr = (JSONArray)plots.get("plot");
 	JSONObject plotJson= (JSONObject)movieplotArr.get(0);
 	String plotText = (String)plotJson.get("plotText");
 	
 	JSONObject directors= (JSONObject)ResultJson.get("directors");
 	JSONArray moviedirectorArr = (JSONArray)directors.get("director");
 	JSONObject directorJson= (JSONObject)moviedirectorArr.get(0);
 	String directorNm = (String)directorJson.get("directorNm");
 	
 	JSONObject actors= (JSONObject)ResultJson.get("actors");
    JSONArray movieactorArr = (JSONArray)actors.get("actor");
    JSONObject actorJson= (JSONObject)movieactorArr.get(0);
 	  
 	String actorNm = "";
 	  
 	for(int j = 0; j<movieactorArr.size(); j++ ){
 		JSONObject actorJson2= (JSONObject)movieactorArr.get(j);
 		actorNm += actorJson2.get("actorNm")+"/";
 	}
    	
%>


<form id="movieform<%=DOCID%>" action="movieadd" method="post">
	<a href="javascript:madd('<%=DOCID%>')" id="movietitle<%=DOCID%>"><%=title3%></a><br>
	
	<img src=<%=realposter%> width="100" height="100" id="movietitle"><br>
	
	<input type="hidden" name="actor_nm" value="<%=actorNm%>">
	<input type="hidden" name="category_id" value="<%=genre%>">
	<input type="hidden" name="movie_id" value="<%=DOCID%>">
	<input type="hidden" name="release_date" value="<%=repRlsDate%>">
	<input type="hidden" name="plot" value="<%=plotText%>">
	<input type="hidden" name="director_nm" value="<%=directorNm%>">
	<input type="hidden" name="rating" value="<%=rating%>">
	<input type="hidden" name="title" value="<%=title3%>">
	<input type="hidden" name="poster" value="<%=realposter%>">
	
	<%=genre %>
	<br>
	<%=DOCID %>
	<br>
	<%=repRlsDate %>
	<br>
	<%=plotText %>
	<br>
	<%=directorNm %>
	<br>
	<%=actorNm %>
	<br>
	<%=rating %>
	<br>
	<br>
</form>
	
<%} %>

</body>
</html>