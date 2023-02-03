package micky.sports.shop.dao;

import java.util.ArrayList;

import micky.sports.shop.dto.OrderMemberDto;
import micky.sports.shop.dto.ProductDto;

public interface OrderDao {

	public void payment(String mId,String pNo,int cCnt);
	
	public ProductDto orderSelect(String pno);
	
	//public OrderMemberDto mtOrderList(String mIdd);
	public ArrayList<OrderMemberDto>  mtOrderList(String mIdd);
	
	
}
