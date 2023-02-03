package micky.sports.shop.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberDto {
	//-------------회원정보---------------
	
	private String m_id; //아이디
	private String m_pw; //패스워드
	private String m_name; //실명
	private int m_tel; //전화번호
	private String m_name2; //닉네임
	private String m_email; //이메일
	private String m_grade; //등급
	private int m_age; //나이
	private String m_gender; //성별
	private int m_cash; //캐시(현금)
	private String m_filesrc; //첨부파일(회원의프로필이미지)
	
	public MemberDto() {
		// TODO Auto-generated constructor stub
	}
}
