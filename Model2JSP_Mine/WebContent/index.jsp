<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>인덱스</title>
</head>
<body>
<h1> WebContent/index.jsp </h1>
<!-- 
	index.jsp 페이지
	프로젝트 시작점으로 이용
	* Model2 방식은 jsp 페이지에 직접 접근 X => 가상주소 이용
	특정 동작마다 각각의 가상주소를 생성해 사용
	ex) ~.me / ~.bo
 -->
 <%
 	response.sendRedirect("./Main.me");
 %>
</body>
</html>