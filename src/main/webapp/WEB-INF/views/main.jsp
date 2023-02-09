<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String loginid = (String)session.getAttribute("loginid"); %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>main.jsp</h3>
<h1>메인화면</h1>
<%if(session.getAttribute("loginid")==null){ 
%>
<input type="button" value="로그인화면" onclick="location.href='loginform'" /> <br />
<%
}else {
%>
<font color="blue"><%=session.getAttribute("loginid") %></font>
님 반가워요
<input type="button" value="로그아웃" onclick="location.href='logout'" /> <br />
<input type="button" value="마이페이지" onclick="location.href='mypageform'" />
<% 
if(loginid.equals("admintest")){
%>
<input type="button" value="관리자페이지" onclick="location.href='adminpage'"/>	
<%
}
%>
<%
}
%>

확인 : ${logincheck_result} 

로그인한 아이디 : ${sessionScope.loginid }

<hr />
<a href="/shop/product/productList">productlist</a> <br />
</body>
</html>