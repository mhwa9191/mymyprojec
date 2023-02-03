package micky.sports.shop.dto;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
	//-------QnA(회원)---------
@Getter
@Setter
public class Qna_MemberDto {

	private int q_mno; //문의번호 (문의번호는 sequence로 처리할예정)
	private String q_mtitle; //문의제목
	private String q_mcontent; //문의내용
	private String q_mreply; //답변내용
	private String q_mid; //문의한고객의id
	private String q_mynn; //답변유무
	private Date q_mdate; //문의날짜
	private int q_mgroup; //그룹
	private int q_mstep; //스텝
	private int q_mindent; //인덴트
	
	public Qna_MemberDto() {
		// TODO Auto-generated constructor stub
	}
}
