<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>상품리스트</h3>
<table width="500" border="1">
	<tr>
		<td>상품</td>
		<td>이름</td>

	</tr>
	<c:forEach items="${productlsit }" var="plist">
		<tr>
			<td>
			<img src="../resources/img/productimg/${plist.p_filesrc }.jpg" width="50" alt="" />
			</td>
			<td>
			<a href="productDetail?pname=${plist.p_name }&pfilesrc=${plist.p_filesrc }">
			${plist.p_name }</a>
			</td>
		</tr>
	</c:forEach>


</table>



</body>
</html>