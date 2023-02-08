package micky.sports.shop.service.member;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import micky.sports.shop.dao.Member;
import micky.sports.shop.service.MickyServiceInter;

public class LogOutService implements MickyServiceInter{

	private SqlSession sqlSession;
	private HttpSession session;
	
	public LogOutService(SqlSession sqlSession,HttpSession session) {
		this.sqlSession = sqlSession;
		this.session = session;
	}
	
	@Override
	public void execute(Model model) {
		System.out.println("LogOutService");
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String loginid = (String)session.getAttribute("loginid");
		
		System.out.println("로그아웃하려는아이디 : "+loginid);
		
		session.removeAttribute("loginid");
		
	}

}
