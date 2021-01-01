package kosta.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ExceptionController {
	
	@RequestMapping("/exception.do")
	public ModelAndView aa(String no) {
		int convertNo = Integer.parseInt(no);
		System.out.println(convertNo);
		
		int result = 1000/convertNo;
		System.out.println("나눈결과 : " + result);
		
		return new ModelAndView("result","message","예외발생없이 정상"); //한개정도만 가지고 넘어갈 때 쓰면 좋음
		//뷰이름,전달한 값에 대한 이름,전달할 값
	}
	
	
	/**
	 * @ExceptionHandler는 현재 Controller에서 발생하는 예외에 대해서만 처리된다.
	 * 다른 Controller에서 발생되는 예외는 처리 할 수 없다.
	 * 
	 * 모든 Controller들이 공유해서 처리해야 할 예외가 있다면
	 * bean설정문서 필요하다.
	 * */
	//@ExceptionHandler(NumberFormatException.class)
	@ExceptionHandler(value = {NumberFormatException.class, ArithmeticException.class})
	public ModelAndView exception(Exception e) {
		System.out.println("오류정보 : " + e.getMessage());
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("errMsg", e.getMessage());
		mv.addObject("errInfo", e.getClass()+"에서 발생했습니다.");
		mv.setViewName("error/errorView"); //WEB-INF/views/error/errorView.jsp
		return mv;
	}
}
