package org.kosta.mvc.user.controller;

import javax.servlet.http.HttpSession;

import org.kosta.mvc.user.domain.Member;
import org.kosta.mvc.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
  
	/**
	 * �α��� ��
	 * */
	@RequestMapping("/login")
	public void login() {}
	
	
	/**
	 * �α���
	 * */
	@RequestMapping("/loginCheck")
	public String loginCheck(Member member , HttpSession session) {
		Member dbMember = userService.loginCheck(member);
		
		//���ǿ� ������ �����Ѵ�.
		if(session!=null) {
		  session.setAttribute("loginUser", dbMember.getUserId());
		  session.setAttribute("loginName", dbMember.getName());
		}
		
		return "redirect:/";
	}
	
	/**
	 * �α׾ƿ�
	 * */
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	
}





