package micky.sports.shop.dto;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdminDto {
	private String c_no; //주문취소번호 : cyyyymmdd+123.... seq  ex) c20230331-1
	private String om_cntnum; //상품주문번호 : yyyymmdd+색상+사이즈 ex) 20230331-r-s
	private int p_price;//총액
	private Date c_date;//주문취소일자
	private String c_reason;//주문취소사유
	private String c_approval;//주문취소승인                     ex) confirm
	
	
	public AdminDto() {
		// TODO Auto-generated constructor stub
	}
	
	
//	public String getC_no() {
//		return c_no;
//	}
//	public void setC_no(String c_no) {
//		this.c_no = c_no;
//	}
//	public String getOm_cntnum() {
//		return om_cntnum;
//	}
//	public void setOm_cntnum(String om_cntnum) {
//		this.om_cntnum = om_cntnum;
//	}
//	public int getP_price() {
//		return p_price;
//	}
//	public void setP_price(int p_price) {
//		this.p_price = p_price;
//	}
//	public Date getC_date() {
//		return c_date;
//	}
//	public void setC_date(Date c_date) {
//		this.c_date = c_date;
//	}
//	public String getC_reason() {
//		return c_reason;
//	}
//	public void setC_reason(String c_reason) {
//		this.c_reason = c_reason;
//	}
//	public String getC_approval() {
//		return c_approval;
//	}
//	public void setC_approval(String c_approval) {
//		this.c_approval = c_approval;
//	}

	
}
