package org.kosta.mvc.user.controller;

import javax.servlet.http.HttpSession;

import org.kosta.mvc.user.domain.Member;
import org.kosta.mvc.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	/**
	 * 로그인 폼
	 * */
	@RequestMapping("/login")
	public void loginForm() {}
	
	
	/**
	 * 로그인
	 * */
	@RequestMapping("/loginCheck")
	public String login(Member member,HttpSession session){
		Member memberDTO = userService.loginCheck(member);
		if(session!=null) {
			session.setAttribute("loginUser", memberDTO.getUserId());
			session.setAttribute("loginName", memberDTO.getName());
		}
		return "redirect:/";
	}
	
	/**
	 * 로그아웃
	 * */
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
//		session.removeAttribute("loginUser");
//		session.removeAttribute("loginName");
		session.invalidate();
		return "redirect:/";
	}
	
//	@ExceptionHandler(Exception.class)
//	public ModelAndView exception(Exception e) {
//		ModelAndView mv = new ModelAndView();
//		mv.addObject("errorMsg", e.getMessage());
//		mv.setViewName("error/errorMessage");
//		return mv;
//	}
}
