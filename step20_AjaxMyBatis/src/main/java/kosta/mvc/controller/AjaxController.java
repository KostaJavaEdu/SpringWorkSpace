package kosta.mvc.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kosta.mvc.dto.MemberDTO;

@RestController //@Controller의 역할 + @ResponseBody를 묶어논 역할 --> 비동기화 통신만 되는 애들
public class AjaxController {

	@RequestMapping(value = "/load", produces = {"text/html;charset=UTF-8"})
	//@ResponseBody 
	public String load() {
		return "spring과 ajax의 만남~";
	}
	
	@RequestMapping(value = "/ajax" , produces = {"text/html;charset=UTF-8"})
	public String ajax(String name) {
		return name + "님 반가워요!";
	}
	
	/**
	 * Spring에서는 jacksonLIB를 이용하면 
	 * ResponseBody로 응답되어지는
	 * 자바의 객체 타입을 json의 형태로 만들어서 브라우저에 응답해준다.'
	 * */
	@RequestMapping(value = "/jsonArr")
	public List<String> jsonArr(){
		List<String> list = Arrays.asList(new String[]{"안녕","사과","딸기","포도","귤"});
		
		return list;
	}
	
	@GetMapping(value = "/jsonDTO")
	public MemberDTO jsonDTO() {
		
		return new MemberDTO("choi", "최수녕", 24, "용인");
	}
	
	@PostMapping("/jsonList")
	public List<MemberDTO> jsonList(){
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		list.add(new MemberDTO("kim", "영희", 25, "서울"));
		list.add(new MemberDTO("tak", "소희", 26, "분당"));
		return list;
	}
	
	@GetMapping("/jsonMap")
	public Map<String, Object> jsonMap(){
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("pageNum", 10);
		map.put("message", "밥먹으로 고고");
		
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		list.add(new MemberDTO("kim", "영희", 25, "서울"));
		list.add(new MemberDTO("tak", "소희", 26, "분당"));
		map.put("list", list);
		map.put("member", new MemberDTO("lee", "효정", 27, "시흥"));
		
		return map;
		
	}
}
