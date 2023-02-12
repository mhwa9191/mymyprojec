<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="../resources/js/jquery-3.6.1.min.js"></script>
<script src="../resources/js/jquery.bpopup.min.js"></script>
</head>
<body>
 ${sessionScope.loginid } 님, 로그인상태입니다 ദ്ദി*ˊᗜˋ*)
<h3>주문하기 </h3>
<div>현재 ${sessionScope.loginid } 님, 남은 캐시는 ${ordersMember.m_cash } 입니다.</div>
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
	<c:set var="totPrices" value="${totPrices+cnt[status.index]*slist.p_price }" />

<hr />
</c:forEach>
총 결제 금액
<c:out value="${totPrices}" />
<input type="hidden" class="totPrices" name="totPrices" value="${totPrices}" /> <br />
<input type="submit" value="결제하기" class="btn_payment"/>
<!-- 결제 금액이 부족한 경우 -->
<div>
	<p class="message-no-cash" style="display: none; color: #CC0099;">결제할 캐시가 부족합니다.</p>
</div>
</form>

<hr />
<!-- 주문페이지에서 결제로 넘어가지 않고 다시 상품페이지로 돌아가기 -->
<a href="/shop/product/productList"><button>취소</button></a>

<hr />
배송비(만원이하 2,500원)
상품할인금액(사이트내에서 할인행사)
주문할인(쿠폰사용,멤버십할인)
총 할인 금액
총 결제 금액 

회원로그인일경우 
비회원구매일경우

<script>
$('.btn_payment').click(function(){
	var m_cash = ${ordersMember.m_cash };
	var totPrices=$('.totPrices').val();
	/* alert(totPrices); */
	if (m_cash < totPrices){
		$('.message-no-cash').css('display','block');
		return false;
	}
});
</script>

</body>
</html>