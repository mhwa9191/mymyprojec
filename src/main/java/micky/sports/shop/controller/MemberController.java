package micky.sports.shop.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import micky.sports.shop.service.MickyServiceInter;
import micky.sports.shop.service.member.JoinIdCheckService;
import micky.sports.shop.service.member.JoinService;
import micky.sports.shop.service.member.LogOutService;
import micky.sports.shop.service.member.LoginService;
import micky.sports.shop.service.member.MemberDeleteService;
import micky.sports.shop.service.member.MemberListService;
import micky.sports.shop.service.member.MemberUpdateFormService;
import micky.sports.shop.service.member.MemberUpdateService;
import micky.sports.shop.service.member.QnaListService;

@Controller
public class MemberController {

	MickyServiceInter mickyServiceInter;
	
	@Autowired
	private SqlSession sqlSession;
	@Autowired
	private HttpSession session;
	
	//메인화면
		@RequestMapping("/main")
		public String main(Model model) {
			System.out.println("@@@MemberController/main()@@@");
			
			return "main";
		}
	//로그인화면
	@RequestMapping("/loginform")
	public String loginform(Model model) {
		System.out.println("@@@MemberController/loginform()@@@");
		
		return "loginform";
	}
	//로그인기능
	@RequestMapping("/login")
	public String login(HttpServletRequest request,Model model) {
		System.out.println("@@@MemberController/login()@@@");
			
		model.addAttribute("request",request);
		mickyServiceInter = new LoginService(sqlSession,session);
		mickyServiceInter.execute(model);
			
		return "main";
	}
	//로그아웃기능
		@RequestMapping("/logout")
		public String logout(HttpServletRequest request,Model model) {
			System.out.println("@@@MemberController/logout()@@@");
				
			model.addAttribute("request",request);
			mickyServiceInter = new LogOutService(sqlSession,session);
			mickyServiceInter.execute(model);
				
			return "main";
		}
	//회원가입화면
	@RequestMapping("/joinform")
	public String joinform(Model model) {
		System.out.println("@@@MemberController/joinform()@@@");
		return "joinform";
	}
	//아이디중복검사기능
	@RequestMapping("/joinidcheck")
	public String joinidcheck(HttpServletRequest request,Model model) {
		System.out.println("@@@MemberController/joinidcheck()@@@");
		
		model.addAttribute("request",request);
		mickyServiceInter = new JoinIdCheckService(sqlSession);
		mickyServiceInter.execute(model);
		
		return "joinform";
	}
	//회원가입기능
	@RequestMapping("/join")
	public String join(HttpServletRequest request,Model model) {
		System.out.println("@@@MemberController/join()@@@");
			
		model.addAttribute("request",request);
		mickyServiceInter = new JoinService(sqlSession);
		mickyServiceInter.execute(model);
			
		return "loginform";
	}
	//마이페이지화면
	@RequestMapping("/mypageform")
	public String mypageform(HttpServletRequest request,Model model) {
		System.out.println("@@@MemberController/mypageform()@@@");
				
				
		return "mypageform";
	}
	//관리자페이지화면
	@RequestMapping("/adminpage")
	public String adminpage(HttpServletRequest request,Model model) {
		System.out.println("@@@MemberController/adminpage()@@@");
			
				
		return "adminpage";
	}
	//회원목록화면
	@RequestMapping("/memberlist")
	public String memberlist(HttpServletRequest request,Model model) {
		System.out.println("@@@MemberController/memberlist()@@@");
		mickyServiceInter = new MemberListService(sqlSession,session);
		mickyServiceInter.execute(model);	
				
		return "memberlist";		
	}
	//회원정보수정화면
	@RequestMapping("/memberupdateform")
	public String memberupdateform(HttpServletRequest request,Model model) {
		System.out.println("@@@MemberController/memberupdateform()@@@");
		model.addAttribute("request", request);
		mickyServiceInter = new MemberUpdateFormService(sqlSession,session);
		mickyServiceInter.execute(model);	
				
		return "memberupdateform";		
	}
	//회원정보수정기능
	@RequestMapping("/memberupdate")
	public String memberupdate(HttpServletRequest request,Model model) {
		System.out.println("@@@MemberController/memberupdate()@@@");
		model.addAttribute("request", request);
		mickyServiceInter = new MemberUpdateService(sqlSession,session);
		mickyServiceInter.execute(model);	
				
		return "redirect:memberlist";		
	}
	//회원정보삭제기능
	@RequestMapping("/memberdelete")
	public String memberdelete(HttpServletRequest request,Model model) {
		System.out.println("@@@MemberController/memberdelete()@@@");
		model.addAttribute("request", request);
		mickyServiceInter = new MemberDeleteService(sqlSession,session);
		mickyServiceInter.execute(model);	
				
		return "redirect:memberlist";		
	}
	//마이페이지의문의게시판리스트
	@RequestMapping("/qnalist")
	public String qnalist(HttpServletRequest request,Model model) {
		System.out.println("@@@MemberController/qnalist()@@@");
		model.addAttribute("request", request);	
		System.out.println("현재로그인중인아이디확인 : "+session.getAttribute("loginid"));
		mickyServiceInter = new QnaListService(sqlSession,session);
		mickyServiceInter.execute(model);	
		return "qnalist";		
	}
}