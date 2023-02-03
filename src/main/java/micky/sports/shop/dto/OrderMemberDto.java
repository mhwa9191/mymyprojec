package micky.sports.shop.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OrderMemberDto {

	private String om_cntnum; // 상품주문번호 yyyymmdd+색상+사이즈
	private String om_num; // 주문번호 yyymmdd+seq
	private String m_id; // 아이디
	private Date om_date; // 주문일자
	private String order_state; // 처리상태
	private String p_no; // 상품번호
	private String om_pay;// 결제형태
	private int u_cnt; // 주문수량
	private String p_color; // 색상
	private String p_size; // 사이즈
	private int p_price; // 총액
	private int om_cancle; // 주문취소여부
	private Date om_cdate; // 주문취소일자

	public OrderMemberDto() {
		// TODO Auto-generated constructor stub
	}


}
