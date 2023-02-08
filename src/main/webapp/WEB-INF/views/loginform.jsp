<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script>
function checkValue(){
	inputForm = eval("document.logininfo");
	if(!inputForm.m_id.value){ //id를 입력하지않으면
		alert("아이디입력없음");
		return false;
	}
	if(!inputForm.m_pw.value){ //pw를 입력하지않으면
		alert("비밀번호입력없음");
		return false;
	}
}
</script>
<h3>loginform.jsp</h3>
<h1>로그인화면</h1>
<form action="login" method="post" name="logininfo" onsubmit="return checkValue()"> <!-- submit 하기 전에 먼저 실행됨 -->
아이디 : <input type="text" name="m_id" /> <br />
비밀번호 : <input type="text" name="m_pw" /> <br />
<input type="submit" value="로그인" /> <!-- 입력한 id,pw를 Controller/login()으로 보내기 -->
<input type="button" value="회원가입" onclick="location.href='joinform'" /> <br />
<input type="button" value="메인화면" onclick="location.href='main'" />
</form>
</body>
</html>