package micky.sports.shop.dto;


import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

//상품 주문페이지로 정보를 보내기 위한 곳
@Getter
@Setter
public class OrderPageDto {

	// 주문페이지로 담아올것
	private ArrayList<OrderPageItemDto> orders;

}
