package micky.sports.shop.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OrderMemberDto {

	private String om_cntnum; // 상품주문번호 seq
	private String om_num; // 주문번호 yyymmdd+id
	private String p_no; // 상품번호
	private int u_cnt; // 주문수량
	private String m_id; // 아이디
	private Date om_date; // 주문일자
	private String om_pay;// 결제형태
	private int p_price; // 총액
	private String om_state; // 처리상태
	private String om_cancle; // 주문취소여부
	private Date om_cdate; // 주문취소일자
	private String c_reason; // 주문취소사유
	
	//private ProductDto productDto; //join product 테이블

	
	
	public OrderMemberDto() {
		// TODO Auto-generated constructor stub
	}


}
