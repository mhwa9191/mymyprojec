package micky.sports.shop.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ReviewDto {
	private int r_no; //리뷰번호
	private String m_id; //회원(member)테이블의 id
	private String r_title; //리뷰제목
	private String r_content; //리뷰내용
	private String r_id; //회원(member)테이블의 관리자 id
	private String r_retitle; //답변제목
	private String r_recontent; //답변내용
	private String r_ynn; //답변유무, 타입 char(1)
	private Date r_date; //작성날짜
	private int r_group; //그룹
	private int r_step; //스텝
	private int r_indent; //인덴트
	private String r_filesrc; //첨부파일
	
	public ReviewDto() {
		// TODO Auto-generated constructor stub
	}
}
