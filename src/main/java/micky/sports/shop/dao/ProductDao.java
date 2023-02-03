package micky.sports.shop.dao;

import java.util.ArrayList;

import micky.sports.shop.dto.ProductDto;

public interface ProductDao {

	//상품목록
	public ArrayList<ProductDto> productlist();
	
	public ArrayList<ProductDto> product(String pname);
	public ArrayList<ProductDto> productMain(String pname);
	public ArrayList<ProductDto> productSelect(String pname);
}
