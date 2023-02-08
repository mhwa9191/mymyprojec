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
 ${sessionScope.loginid } 님, 로그인상태입니다 ദ്ദി*ˊᗜˋ*)
<h3>주문하기 </h3>
<hr />
<h5>구매할 상품</h5>

<form action="payment" method="post">
<c:forEach items="${orderPSelectList}" var="slist" varStatus="status">
<div>
	<img src="../resources/img/productimg/${slist.p_filesrc }.jpg" width="50" alt="" /> <br />
	<input type="text" name="p_no" value="${slist.p_no }"/>
	<input type="text" name="cnt" value="${cnt[status.index] }"/> <br />
	상품명 : <div id="p_name">${slist.p_name }</div> <br />
	색상 : <div id="p_color">${slist.p_color }</div> <br />
	사이즈 : <div id="p_size">${slist.p_size }</div> <br />
	수량 : <div id="cnt" >${cnt[status.index] }</div> <br />
	총액 : <div id="totPrice">${cnt[status.index]*slist.p_price }</div> <br />
</div>
<hr />
</c:forEach>


<input type="submit" value="결제하기" />
</form>

<hr />
배송비(만원이하 2,500원)
상품할인금액(사이트내에서 할인행사)
주문할인(쿠폰사용,멤버십할인)
총 할인 금액
총 결제 금액 

회원로그인일경우 
비회원구매일경우

</body>
</html>