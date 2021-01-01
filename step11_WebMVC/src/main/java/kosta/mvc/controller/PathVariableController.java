package kosta.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("/blog")
public class PathVariableController {
	
	@RequestMapping(value = "/{type}/{id}.do")
	public String aa(@PathVariable String id, @PathVariable String type) {
		System.out.println("PathVariable실행됨.....");
		return "result";
	}
	
	/**
	 * 요청 정보 : blog/*
	 * */
	@RequestMapping("/{id}") 
	public void blog(@PathVariable String id) {
		System.out.println("blog/*에 의해 요청됨 : " + id);
	}
	
	@RequestMapping("/{type}/{id}/{no}")
	public void blog2(@PathVariable String type, @PathVariable String id, @PathVariable Integer no) {
		System.out.println("blog2/*에 의해 요청됨 : \n" + id + "\n" + type + "\n" + no);
	}
}
