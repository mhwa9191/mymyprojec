package micky.sports.shop.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import micky.sports.shop.dao.ProductDao;
import micky.sports.shop.service.MickyServiceInter;

@Controller
@RequestMapping("/product")
public class ProductController {
	MickyServiceInter mickyServiceInter;

	@Autowired
	private SqlSession sqlSession;
	
	//상품목록
	@RequestMapping("/productLsit")
	public String productLsit(HttpServletRequest request, Model model) {
		System.out.println("========productLsit=======");
		//db에서 데이터 가져오기
		ProductDao Pdao=sqlSession.getMapper(ProductDao.class);
		model.addAttribute("productlsit",Pdao.productlist());
		
		return "/product/productList";
	}
	//상품페이지
	@RequestMapping("/productDetail")
	public String product(HttpServletRequest request, Model model) {
		System.out.println("========product=======");
		
		String pname=request.getParameter("pname");

		ProductDao Pdao=sqlSession.getMapper(ProductDao.class);
		model.addAttribute("productMain",Pdao.productMain(pname));
		model.addAttribute("product",Pdao.product(pname));
		model.addAttribute("productSelect",Pdao.productSelect(pname));
		
		return "/product/productDetail";
	}
	

}
