package kosta.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
	
	@RequestMapping("/test.do")
	public void aa(String no) { //WEB-INF/views/test.jsp이동
		System.out.println("TestController 의 test.do 요청됨");
		int convertNo = Integer.parseInt(no);
	}
}
