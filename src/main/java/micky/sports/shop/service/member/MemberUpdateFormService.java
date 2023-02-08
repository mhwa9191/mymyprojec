package micky.sports.shop.service.member;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import micky.sports.shop.dao.Member;
import micky.sports.shop.dto.MemberDto;
import micky.sports.shop.service.MickyServiceInter;

public class MemberUpdateFormService implements MickyServiceInter{

	private SqlSession sqlSession;
	private HttpSession session;
	
	public MemberUpdateFormService(SqlSession sqlSession,HttpSession session) {
		this.sqlSession = sqlSession;
		this.session = session;
	}
	
	@Override
	public void execute(Model model) {
		System.out.println("MemberUpdateFormService");
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String m_id = request.getParameter("m_id");
		System.out.println("수정하고싶은 아이디 :"+m_id);
		
		Member dao = sqlSession.getMapper(Member.class);
		
		MemberDto dto = dao.memberupdateform(m_id);
		
		model.addAttribute("memberupdate_id",dto);
	}

}
