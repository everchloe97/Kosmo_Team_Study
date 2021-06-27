<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login</title>
</head>
<body>
<h1>WebContent/member/loginForm.jsp</h1>

<fieldset>
	<legend>로그인</legend>
	
	<form action="./MemberLoginAction.me" method="post">
		<label for="id">아이디 : </label> <input type="text" name="id"> <br>
		<label for="pass">비밀번호 : </label> <input type="password" name="pass"> <br>
		<input type="submit" value="로그인">
	</form>
	
	<input type="button" value="회원가입" onclick="location.href='./MemberJoin.me'">
	
</fieldset>

</body>
</html>