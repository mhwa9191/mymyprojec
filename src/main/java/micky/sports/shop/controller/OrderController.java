package micky.sports.shop.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import micky.sports.shop.service.MickyServiceInter;
import micky.sports.shop.service.order.MyOrderListService;
import micky.sports.shop.service.order.OrderPageService;
import micky.sports.shop.service.order.OrderPaymentService;

@Controller
@RequestMapping("/order")
public class OrderController {
	MickyServiceInter mickyServiceInter;

	@Autowired
	private SqlSession sqlSession;
	@Autowired
	private HttpSession httpsession;
	
	//주문하는 페이지
	@RequestMapping("/orderPage")
	public String orderView(HttpServletRequest request, Model model) {
		System.out.println("========orderPage=======");
		
		model.addAttribute("request",request);
		mickyServiceInter=new OrderPageService(sqlSession,httpsession);
		mickyServiceInter.execute(model);
		
		return "/order/orderPage";
	}
	
	// 주문 기능 payment
	@RequestMapping("/payment")
	public String payment(HttpServletRequest request, Model model) {
		System.out.println("========payment=======");
		
		model.addAttribute("request",request);
		mickyServiceInter=new OrderPaymentService(sqlSession,httpsession);
		mickyServiceInter.execute(model);
		
		return "redirect:myOrderList";
	}
	
	//나의 주문 내역보기
	@RequestMapping("/myOrderList")
	public String orderList(HttpServletRequest request, Model model) {
		System.out.println("========myOrderList=======");
		
		model.addAttribute("request",request);
		mickyServiceInter=new MyOrderListService(sqlSession,httpsession);
		mickyServiceInter.execute(model);
		
		return "/order/myOrderList";
	}
	
}
