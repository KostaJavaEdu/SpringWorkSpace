package kosta.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kosta.mvc.model.service.MemberService;
import kosta.mvc.model.vo.Member;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private MemberService memberService;
	

	/**
	 * admin/main
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
