package micky.sports.shop.dto;


import lombok.Getter;
import lombok.Setter;

//상품 주문페이지로 정보를 보내기 위한 곳
@Getter
@Setter
public class OrderPageItemDto {

	private String p_no; //구매를 누른 상품의 상품번호
	private int pCount; //구매할 상품의 수량
	
	//DB 상품테이블에서 꺼내올 값들
	private String p_name; //상품명
	private int p_price; //상품 가격
	//색상과 사이즈는 확인사항 
	private String p_color; //상품 색상
	private String p_size; // 상품 사이즈
	private String p_filesrc; // 상품 첨부사진
	
	//여기서 만들 값
	private int totalPrice;
	
	public void inintTotal() { //구매할 상품의 총액
		this.totalPrice=this.p_price*this.pCount;
		//System.out.println("========inintTotal======="+totalPrice);
	}
	


}
