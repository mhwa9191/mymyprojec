package micky.sports.shop.dto;

import lombok.Getter;
import lombok.Setter;

//장바구니 테이블
@Getter
@Setter
public class CartDto {
	private String c_no;//장바구니번호
	private String m_id;//회원아이디
	private String p_no;//상품번호
	private int c_cnt;//상품의 수량
	private String c_send;//배송 유무 (배송준비,배송완료)
	
	public CartDto() {
		// TODO Auto-generated constructor stub
	}
}
