package kosta.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@Controller
@RestController //@Controller + @ResponseBody 동시 --> 비동기화 통신할 때 컨트롤러 
public class ResponseBodyController {
	
	@RequestMapping(value = "/responseBody.do", produces = {"text/html;charset=UTF-8"})
	//@ResponseBody //리턴되는 값이 그래도 응답 객체가 된다. 
	public String aa() {
		
		return "Have a good day - 좋은하루~~";
	}
	
	@RequestMapping(value = "/responseBody2.do", produces = {"text/html;charset=UTF-8"})
	//@ResponseBody //주로 에이작스 처리 할 때 사용 많이 한다. 
	public String bb() {
		
		return "밥 먹으러 고고~~";
	}
}
