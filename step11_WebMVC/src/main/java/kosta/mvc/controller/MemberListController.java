package kosta.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kosta.mvc.domain.MemberDTO;
import kosta.mvc.domain.MemberListDTO;

@Controller

public class MemberListController {
	
	@RequestMapping("/list/memberMulti.do")
	public String list(MemberListDTO listDTO) {
		System.out.println("***************************");
		for( MemberDTO dto : listDTO.getList()) {
			System.out.println("선택 : " + dto.isState());
			System.out.println("이름 : " + dto.getName());
			System.out.println("나이 : " + dto.getAge());
			System.out.println("주소 : " + dto.getAddr());
		}
		return "listResult"; //WEB-INF/views/listResult.jsp이동
	}
}
