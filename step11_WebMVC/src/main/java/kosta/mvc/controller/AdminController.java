package kosta.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {

	@RequestMapping("/a.admin")
	public String aa() {
		System.out.println("a.admin이 호출되었습니다.");
		
		return "result";
	}
}
