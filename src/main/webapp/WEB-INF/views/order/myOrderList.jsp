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
<c:if test="${empty sessionScope.loginid }">
   <a href="../loginform">login</a> 
   |  <a href="">join</a>

</c:if>
 <c:if test="${not empty sessionScope.loginid }">
    <a href="../logout">logout</a> 
 <br />
 ${sessionScope.loginid } 님, 로그인상태입니다 ദ്ദി*ˊᗜˋ*)
 </c:if>
 
 
 <div>
	<p class="go-productList" style="color: #336666;">
	<a href="../product/productList">상품둘러보기</a>
	</p>
 </div>
 <div>
 	<p>회원님의 현재 보유 캐시 : ${myList.m_cash }</p>
 </div>
 DATECNT

 <h3>나의주문내역 </h3>
<table width="800" border="1">
	<tr>
		<td>주문날짜</td>
		<td>주문번호</td>
		<td>상품명</td>
		<td>색상</td>
		<td>사이즈</td>
		<td>주문수량</td>
		<td>총액</td>
		<td>결제형태</td>
		<td></td>
	</tr>
	<c:forEach items="${omdList }" var="mlist">
	<tr>
		<td>${mlist.orderMemberDto.om_date }</td>
<%-- 		<c:set value="${mlist.orderMemberDto.om_date }" var="omdate" />
			<c:choose>
				<c:when test="${mlist.orderMemberDto.om_date ne omdate }">
				<td>
				<c:out value="${mlist.orderMemberDto.om_date }"></c:out>
				</td>
				</c:when>
		
				<c:when test="${mlist.orderMemberDto.om_date eq omdate }">
				<td>
				<c:out value=""></c:out>
				</td>
				</c:when>
			</c:choose> --%>
		<td>${mlist.orderMemberDto.om_num }</td>
		<td>${mlist.p_name }</td>
		<td>${mlist.p_color }</td>
		<td>${mlist.p_size }</td>
		<td>${mlist.orderMemberDto.u_cnt }</td>
		<td>${mlist.orderMemberDto.p_price }</td>
		<td>${mlist.orderMemberDto.om_state }</td>
		<td>
			<button>결제취소</button>
			<button>리뷰쓰기</button>
		</td>
	</tr>
	</c:forEach>
</table>

</body>
</html>