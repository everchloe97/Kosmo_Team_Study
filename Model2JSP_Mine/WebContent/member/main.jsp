<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Main</title>
</head>
<body>

<h1> WebContent/member/main.jsp </h1>

<%
	// 세션 객체 안에 있는 id값을 가져와서 로그인 여부 판단
	String id = (String)session.getAttribute("id");

	if(id == null) {
		response.sendRedirect("./MemberLogin.me");
	}
	
	// 아이디가 있을 경우, "ooo님이 로그인하셨습니다" 페이지 출력
%>

<h2><%= id %>님이 로그인하셨습니다</h2>

</body>
</html>