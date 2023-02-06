<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<h3>상품</h3>

<div>
	<c:forEach items="${productMain }" var="pm">
		<div>
			<input type="hidden" name="pname" value="${pm.p_name }" />
			<input type="hidden" name="pfilesrc" value="${pm.p_filesrc }" /> 
			<a href="productDetail?pname=${pm.p_name }&pfilesrc=${pm.p_filesrc }">
			<img src="../resources/img/productimg/${pm.p_filesrc }.jpg" width="50" class="product_img" alt="" />
			</a>
			<input type="hidden" name="pcolor" value="${pm.p_color }" />
		</div>
	</c:forEach>

	<c:forEach items="${product }" var="p" begin="1" end="1">
<span>색상</span>
		<span>${p.p_color }</span>
	</c:forEach>

<p>사이즈</p>
	<c:forEach items="${product }" var="p">
	<div class="productSelect">
		<input type="radio" class="sizeNo" name="sizeNo" value="${p.p_no }" onclick="sizeNo('${p.p_no }',${p.p_cnt });" />${p.p_size }
	</div>
	</c:forEach>
</div>


<!-- 선택한 목록 -->
<div class="choice">
	<div id="optAdd">

	<span>수량</span>
		<input type="hidden" class="cnttot" name="재고수량" value="" />
		<input type="text" class="cnt" name="cnt" value="0" size="3" readonly="readonly" style="text-align: center;" />
		<button type="button" onclick="Count('minus');">-</button>
		<button type="button" onclick="Count('plus');">+</button>

	</div>
	<!-- 선택취소 btnDelChoiceItem -->

</div>

<form action="../order/orderPage" method="post" class="order_form">
	<input type="text" name="orders.p_no" value="" />
	<input type="hidden" name="orders.u_cnt" value="" />

</form>
<button class="btn_buy">바로구매</button>

<script>
	function Count(type) { /* ths [object HTMLButtonElement] */
		var tCount = Number($(".cnt").val());
		var tEqCount = Number($(".cnttot").val());

		if (type == 'plus') {
			if (tCount < tEqCount)
				$(".cnt").val(Number(tCount) + 1);
		} else {
			if (tCount > 0)
				$(".cnt").val(Number(tCount) - 1);
		}
	}
</script>
<!-- <script>
/* 상품 사진 선택시 사이즈 보이기 */
$(".product_img").on("click",function() {
/* 	alert("사진선택"); */
	$(".productSelect").attr("style", "display:block");
});
</script> -->
<script>
	/* 사이즈 선택시 */
	/* 해당 사이즈의 재고량 변화 */
	var selectList = new Array();
	function sizeNo(pno,totcnt) {		
		$(".cnttot").val(totcnt);
		var pNo = $("input[name=sizeNo]:checked").val();
		selectList.push(pNo);
		$(".order_form").find("input[name='orders.p_no']").val(pNo);
	}
	$(".btn_select").on("click",function() {
		var pNo = $("input[name=sizeNo]:checked").val();
	});
	
</script>
<script>
	/* 바로구매버튼 클릭시 */
	$(".btn_buy").on("click",function() {
		let pCount = $(".cnt").val();
		$(".order_form").find("input[name='orders.u_cnt']").val(pCount);
		$(".order_form").submit();
	});
</script>

<script>
	/* 주문 페이지 이동 */	
	$(".order_btn").on("click", function(){
		
		let form_contents ='';
		let orderNumber = 0;
		
		$(".cart_info_td").each(function(index, element){
			
			if($(element).find(".individual_cart_checkbox").is(":checked") === true){	//체크여부
				
				let bookId = $(element).find(".individual_bookId_input").val();
				let bookCount = $(element).find(".individual_bookCount_input").val();
				
				let bookId_input = "<input name='orders[" + orderNumber + "].bookId' type='hidden' value='" + bookId + "'>";
				form_contents += bookId_input;
				
				let bookCount_input = "<input name='orders[" + orderNumber + "].bookCount' type='hidden' value='" + bookCount + "'>";
				form_contents += bookCount_input;
				
				orderNumber += 1;
				
			}
		});	

		$(".order_form").html(form_contents);
		$(".order_form").submit();
		
	});
</script>
	장바구니

</body>
</html>