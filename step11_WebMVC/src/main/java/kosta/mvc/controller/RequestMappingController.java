package kosta.mvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/rem")
public class RequestMappingController {
	
	@RequestMapping("/a.do")
	public ModelAndView test(){
		System.out.println("a.do가 요청되었습니다.");
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("result"); //WEB-INF/views/result.jsp
		mv.addObject("message","a.do결과입니다.");
		return mv;
	}
	
	/**
	 * 여러 개의 요청 정보가 같은 메소드를 호출하도록 설정
	 * 
	 * @return: String 인 경우 리턴 정보가 뷰의 이름된다.
	 * 			뷰쪽으로 전달 할 정보가 없을때...
	 * */
	@RequestMapping(value ={"/b.do","c.do"})
	public String bb() {
		System.out.println("b.do OR c.do 요청됨...");
		return "home"; //WEB-IMF/views/home.jsp로 이동 
	}
	
	/**
	 * 요청방식을 구분하기
	 * 
	 * @return: void인 경우 요청된 정보가 뷰의 이름이 된다.
	 * 			ex) url주소에서 a.do 요청되면 뷰의이름이 a가 된다.
	 * 			ex) rem/test.do 요청되면 뷰 이름인 rem/test가 된다.
	 * 			    그래서 결국 /WEB-INF/views/rem/test.jsp 실행된다.
	 * */
	//@RequestMapping(value = "/test.do", method = RequestMethod.POST)
	@PostMapping("/test.do")
	public void aaa(HttpServletRequest request) {
		String name = request.getParameter("name");
		System.out.println("POST요청 : test.do가 요청되었습니다.");
		System.out.println("name : " + name);
	}
	
	//@RequestMapping(value = "/test.do", method = RequestMethod.GET)
	@GetMapping("/test.do")
	public void bbb(HttpServletRequest request) {
		String name = request.getParameter("name");
		System.out.println("GET요청 : test.do가 요청되었습니다.");
		System.out.println("name : " + name);
	}
	
	/**
	 * parameter의 정보를 기준으로 Mapping처리하기
	 * */
	//@RequestMapping(value = "/a.do" , params = {"id"})
	//@RequestMapping(value = "/a.do" , params = {"id=jang"})
	//@RequestMapping(value = "/a.do" , params = {"id","age"})
	@RequestMapping(value = "/a.do" , params = {"id!=jang"})
	public void dd(String id) {
		System.out.println("a.do의 params 정보 호출되었습니다.");
		System.out.println("id : " + id);
	}
}