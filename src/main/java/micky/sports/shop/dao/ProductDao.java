package micky.sports.shop.dao;

import java.util.ArrayList;

import micky.sports.shop.dto.ProductDto;

public interface ProductDao {

	//상품목록
	public ArrayList<ProductDto> productlist();
	
	public ArrayList<ProductDto> productMain(String pname);
	public ArrayList<ProductDto> product(String pname, String pfilesrc);
	
	public ArrayList<ProductDto> productSelect(String pname, String pcolor);
	
	//구매한 수량 재고 삭제
	public void delpayment(String pno,int cnt);
}
