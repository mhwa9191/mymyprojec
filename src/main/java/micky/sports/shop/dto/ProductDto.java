package micky.sports.shop.dto;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductDto {
	private String p_no; //상품번호
	private String p_name; //상품명
	private int p_price; //가격
	private int p_cnt; //재고
	private String p_color; //색상
	private String p_size; //사이즈
	private String p_filesrc; //첨부파일
	
	public ProductDto() {
		// TODO Auto-generated constructor stub
	}
}
