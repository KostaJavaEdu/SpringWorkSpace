package kosta.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("DeleteController 입니당.");
		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("deleteResult.jsp");
		request.setAttribute("message", "너무 졸려요");
		
		return mv;
	}

}
