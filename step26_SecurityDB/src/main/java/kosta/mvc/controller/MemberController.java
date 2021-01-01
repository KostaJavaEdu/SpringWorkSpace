package kosta.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kosta.mvc.model.service.MemberService;
import kosta.mvc.model.vo.Member;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	/**
	 * 가입 폼
	 * */
	@RequestMapping("/joinForm")
	public void joinForm() {}
	
	/**
	 * 가입하기
	 * */
	@RequestMapping("/join")
	public String join(Member member) {
		//service호출
		memberService.joinMember(member);
		return "member/joinSuccess";
	}
	
	/**
	 * 로그인 폼
	 * */
	@RequestMapping("/loginForm")
	public void loginForm() {}
	

	/**
	 * member/main
	 * */
	@RequestMapping("/main")
	public void main() {}
	
	
	
	@ExceptionHandler(RuntimeException.class)
	public ModelAndView exception(RuntimeException e) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("errMsg",e.getMessage());
		mv.setViewName("error/errorMessage");
		return mv;
	}
}
