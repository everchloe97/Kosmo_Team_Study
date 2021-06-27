<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Join</title>
</head>
<body>
<h1>WebContent/member/insertForm.jsp</h1>

	<fieldset>
	
		<legend>회원가입</legend>
		
		<form action="./MemberJoinAction.me" method="post">
			아이디 : <input type="text" name="id"><br>
	 		비밀번호 : <input type="password" name="pass"><br>
	 		이름: <input type="text" name="name"> <br>
	 		나이: <input type="text" name="age"> <br>
	 		성별: <input type="radio" name="gender" value="남">남
		  		 <input type="radio" name="gender" value="여">여  <br>
		  	이메일 : <input type="email" name="email"><br>
			
	    	<input type="submit" value="회원가입">
	    	<input type="reset" value="초기화">
    	</form>
    	
    	<input type="button" value="돌아가기" onclick="location.replace('./MemberLogin.me')">
    	
	</fieldset>
</body>
</html>