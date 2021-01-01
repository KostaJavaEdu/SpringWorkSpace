package kosta.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class DeleteController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("DeleteController 입니당.");
		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("deleteResult"); //prefix+뷰이름+suffix
		//request.setAttribute("message", "너무 졸려요");
		mv.addObject("message","너무졸려요"); //뷰에서 requestScope.message와동일
		
		return mv;
	}

}
