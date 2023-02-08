package micky.sports.shop.service.product;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import micky.sports.shop.dao.ProductDao;
import micky.sports.shop.service.MickyServiceInter;

public class ProductDetailService implements MickyServiceInter{
	private SqlSession sqlSession;
	private HttpSession httpsession;
	public ProductDetailService(SqlSession sqlSession,HttpSession httpsession) {
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
		
		String pname=request.getParameter("pname");
		String pfilesrc=request.getParameter("pfilesrc");
		System.out.println("====**"+pfilesrc+pname);
		
		ProductDao Pdao=sqlSession.getMapper(ProductDao.class);
		model.addAttribute("productMain",Pdao.productMain(pname));
		model.addAttribute("product",Pdao.product(pname,pfilesrc));
		//model.addAttribute("productSelect",Pdao.productSelect(pname,pcolor));

	}

}
