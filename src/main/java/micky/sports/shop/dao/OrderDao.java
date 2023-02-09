package micky.sports.shop.dao;

import java.util.ArrayList;

import micky.sports.shop.dto.MemberDto;
import micky.sports.shop.dto.OrderMemberDto;
import micky.sports.shop.dto.ProductDto;

public interface OrderDao {

	public void payment(String mId,String pNo,int cCnt);
	
	//주문페이지 정보보기
	public ArrayList<ProductDto> orderSelect(String pno);
	
	//public OrderMemberDto mtOrderList(String mIdd);
	public ArrayList<OrderMemberDto>  mtOrderList(String mIdd);
	
	//주문페이지에서 회원 정보확인
	public MemberDto ordersMember(String loginId);
	

}
