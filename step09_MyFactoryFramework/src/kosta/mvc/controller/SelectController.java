package kosta.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SelectController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("SelectController입니당");
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("selectResult.jsp"); //forward방식
		request.setAttribute("message", "메시지출력"); //${message}
		
		return mv;
	}

}
