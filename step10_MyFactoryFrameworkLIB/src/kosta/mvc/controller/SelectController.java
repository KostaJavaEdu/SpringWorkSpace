package kosta.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class SelectController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("SelectController입니당");
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("selectResult"); //forward방식
		//request.setAttribute("message", "메시지출력"); //${message}
		mv.addObject("message","검색결과입니다.");
		return mv;
	}

}
