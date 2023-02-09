package micky.sports.shop.service.order;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import micky.sports.shop.dao.OrderDao;
import micky.sports.shop.dto.OrderMemberDto;
import micky.sports.shop.service.MickyServiceInter;

public class MyOrderListService implements MickyServiceInter{
	private SqlSession sqlSession;
	private HttpSession httpsession;
	public MyOrderListService(SqlSession sqlSession,HttpSession httpsession) {
		this.sqlSession=sqlSession;
		this.httpsession=httpsession;
	}
	@Override
	public void execute(Model model) {
		Map<String, Object> map=model.asMap();
		HttpServletRequest request=
				(HttpServletRequest)map.get("request");	
		
		//로그인 세션
		httpsession = request.getSession();
		String loginId = (String)httpsession.getAttribute("loginid");
		//System.out.println("*********~~~~~~~~~~~~~~~~~"+loginId);
		
		OrderDao odao=sqlSession.getMapper(OrderDao.class);
		System.out.println("-");
		ArrayList<OrderMemberDto> omdList=odao.mtOrderList(loginId);

		model.addAttribute("omdList",omdList);
		
		//나의주문내역에서 정보확인
		model.addAttribute("myList",odao.ordersMember(loginId));
		
	}

}
