package kosta.web.mvc.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AjaxController {

	@RequestMapping("/test")
	public String test() {
		System.out.println("test요청됨...");
		return"SpringBoot Start! 좋다.";
	}
	
	@RequestMapping("/test2")
	public List<String> test2(){
		List<String> list = Arrays.asList(new String[] {"사과","딸기","포도","복숭아"});
		return list;
	}
}
