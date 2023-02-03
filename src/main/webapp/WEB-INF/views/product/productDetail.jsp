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
			<img src="../resources/img/productimg/${pm.p_filesrc }.jpg" width="50" alt="" />
			<input type="checkbox" name="color" value="${pm.p_color }" />${pm.p_color }
		</div>
	</c:forEach>

</div>
	
<div>
	<p>사이즈</p>
	<c:forEach items="${productSelect }" var="p">
			<div>
			<input type="radio" class="sizeNo" name="sizeNo" value="${p.p_no }" onclick="sizeNo(this);" />${p.p_size }
			<input type="hidden" class="cnttot" name="재고수량" value="${p.p_cnt }" />
			</div>
	</c:forEach>
</div>
<div>
	<p>수량</p>
	<div>
		<button type="button" onclick="Count('minus');">-</button>
		<input type="text" class="cnt" name="cnt" value="0" readonly="readonly" style="text-align: center;" />
		<button type="button" onclick="Count('plus');">+</button>
	</div>
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
<script>

	/* 사이즈 선택시 */
	var selectList = new Array();
	function sizeNo() {
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