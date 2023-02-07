package micky.sports.shop.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import micky.sports.shop.dao.OrderDao;
import micky.sports.shop.dao.ProductDao;
import micky.sports.shop.dto.OrderMemberDto;
import micky.sports.shop.dto.ProductDto;
import micky.sports.shop.service.MickyServiceInter;

@Controller
@RequestMapping("/order")
public class OrderController {
	MickyServiceInter mickyServiceInter;

	@Autowired
	private SqlSession sqlSession;
	
	
	//주문하는 페이지
	@RequestMapping("/orderPage")
	public String orderView(HttpServletRequest request, Model model) {
		System.out.println("========orderPage=======");
		
		//String mId=request.getParameter("m_id"); //아이디
		//String p_no=request.getParameter("p_no"); //상품번호
		//int cCnt=Integer.parseInt(request.getParameter("cnt")); //수량
//		System.out.println(pname+"***"+size+"***"+color);
//		model.addAttribute("cCnt",cCnt);
//		
		
		//전체 스트링으로 받아서 ,로 구분하여 사용해보는 방법을 먼저 하기
		//DTO 이용해서 파람값을 여러개 보내려면 에이젝스나 자바스크립트를 이용하는 편이므로...
		
		// TODO 230203 상품번호 하나와 상품수량만 확인 가능
		String[] no=request.getParameterValues("choice_pno"); 
		String[] cnt=request.getParameterValues("choice_cnt"); 
		OrderDao odao = sqlSession.getMapper(OrderDao.class);
		ArrayList<ProductDto> orderPSelect =new ArrayList<ProductDto>();
		ArrayList<Integer> cnts=new ArrayList<Integer>();
		for (int i = 0; i < no.length; i++) {
			System.out.println("**********"+no[i]);
			System.out.println("**********"+cnt[i]);
			orderPSelect.addAll(odao.orderSelect(no[i]));
			cnts.add(Integer.parseInt(cnt[i]));
		}
		model.addAttribute("orderPSelectList",orderPSelect);
		model.addAttribute("cnt",cnts);
		
		return "/order/orderPage";
	}
	
	// 주문 기능 payment
	@RequestMapping("/payment")
	public String payment(HttpServletRequest request, Model model) {
		System.out.println("========payment=======");
		
		//String mId=request.getParameter("m_id"); //아이디
		// TODO 230203 mId 추후수정
		String mId="blue2"; 
		String pNo=request.getParameter("p_no"); //상품번호
		int cnt=Integer.parseInt(request.getParameter("cnt")); //수량
		//System.out.println("cnt");
		//System.out.println("pNo"+pNo);
		
		OrderDao odao=sqlSession.getMapper(OrderDao.class);
		odao.payment(mId,pNo,cnt);
		
		//구매한 수량 재고 삭제
		ProductDao pdao=sqlSession.getMapper(ProductDao.class);
		pdao.delpayment(pNo,cnt);
		
		//model.addAttribute("pNo",pNo);
		model.addAttribute("mId",mId);
		
		return "redirect:myOrderList";
	}
	
	//나의 주문 내역보기
	@RequestMapping("/myOrderList")
	public String orderList(HttpServletRequest request, Model model) {
		System.out.println("========myOrderList=======");
		
		// TODO 230203 mId 추후수정
		String mId=request.getParameter("mId");
		System.out.println("mId: "+mId);
		//String mId=request.getParameter("m_id"); //아이디

		
		OrderDao odao=sqlSession.getMapper(OrderDao.class);
		System.out.println("-");
		ArrayList<OrderMemberDto> omdList=odao.mtOrderList(mId);
		//OrderMemberDto omdList=odao.mtOrderList(mId);
		
		System.out.println("??");
//		System.out.println(omdList.getOm_cntnum());
		model.addAttribute("omdList",omdList);
		
		return "/order/myOrderList";
	}
	
}
