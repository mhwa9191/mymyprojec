<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>나의주문내역 </h3>

<%-- ${pNo }
${cCnt } --%>

<table width="800" border="1">
	<tr>
		<td>주문번호</td>
		<td>주문자</td>
		<td>상품명</td>
		<td>주문수량</td>
		<td>색상</td>
		<td>사이즈</td>
		<td>총액</td>
		<td>결제형태</td>
	</tr>
	<c:forEach items="${omdList }" var="mlist">
	<tr>
		<td>${mlist.orderMemberDto.om_num }</td>
 		<td>${mlist.orderMemberDto.m_id }</td>
		<td>${mlist.p_name }</td>
		<td>${mlist.orderMemberDto.u_cnt }</td>
		<td>${mlist.p_color }</td>
		<td>${mlist.p_size }</td>
		<td>${mlist.orderMemberDto.p_price }</td>
		<td>${mlist.orderMemberDto.om_state }</td>
	</tr>
	</c:forEach>
</table>

</body>
</html>