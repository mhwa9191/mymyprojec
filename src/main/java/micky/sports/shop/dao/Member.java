package micky.sports.shop.dao;

import java.util.ArrayList;

import micky.sports.shop.dto.MemberDto;
import micky.sports.shop.dto.Qna_MemberDto;

public interface Member {
	
	public void join(String m_id,String m_pw,String m_name,String m_tel,String m_name2,String m_email,
			String m_grade,int m_age,String m_gender,int m_cash,String m_filesrc);
	public int login(String loginform_inputid,String loginform_inputpw);
	public int joinidcheck(String m_id);
	public ArrayList<MemberDto> getmemberlist();
	public MemberDto memberupdateform(String m_id);
	public void memberupdate(String m_id, String m_pw, String m_name, String m_tel, String m_name2, String m_email, String m_grade,
			int m_age, String m_gender, int m_cash, String m_filesrc);
	public void memberdelete(String m_id);
	public ArrayList<Qna_MemberDto> getqnalist(String m_id);
}
