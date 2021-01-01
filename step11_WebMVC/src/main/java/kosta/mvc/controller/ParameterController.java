package kosta.mvc.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kosta.mvc.domain.MemberDTO;


@Controller
@RequestMapping("/param")
public class ParameterController {
	
//	@RequestMapping("a.do")
//	public ModelAndView aa(HttpServletRequest request) {
//		String name = request.getParameter("name");
//		int age = Integer.parseInt(request.getParameter("age"));
//		
//		System.out.println("이름 : " + name +"\n"+ "나이 : " + age);
//		
//		ModelAndView mv = new ModelAndView("paramResult"); //WEB-IMF/views/paramResult.jsp
//		return mv;
//	}
	
	/**
	 * 인수로 전달받은 모델 객체는 뷰쪽으로 전달할 데이터를 저장할 저장소이다. 
	 * Mpdel에 데이터를 저장하면 뷰page에서 EL과 JSTL으로 사용할 수 있다.(requestScope에 저장된다.)
	 * */
	@RequestMapping("/a.do")
	public String aa(String name, Integer age, Model model) {
		System.out.println("이름 : " + name +"\n"+ "나이 : " + age);
		
		model.addAttribute("hobbys", new String[]{"등산","수영","낚시","골프"});
		
		return "paramResult"; //뷰 이름 된다.
	}
	
	
	/**
	 * 폼이 전송될 때 일수로 폼에 있는 input 요소들의 name과 동일한
	 * property를 가지고 있는 DTO를 선언하면 자동 매핑된다.(setXxx() 호출됨)
	 * 
	 * 전송된 데이터를 DTO형태로 받으면 그 정보가 그대로 결과 뷰 페이지로 전달된다.
	 * 뷰 페이지에서 정보 사용가능
	 * 사용방법 : MemberDTO타입의 첫 글자만 소문자로 작성한다.
	 * 				ex) ${memberDTO.속성}
	 * 
	 * 				만약 인수에 @ModelAttribute("dto") 를 선언하면
	 * 				뷰에서 ${dto.속성}
	 * 
	 * void는 요청 주소가 뷰 이름된다. : WEB-INF/views/param/c.jsp
	 * */
	@RequestMapping("/c.do")
	public void cc(@ModelAttribute("dto") MemberDTO dto, HttpSession session) {
		System.out.println("아이디 : " + dto.getId());
		System.out.println("이름 : " + dto.getName());
		System.out.println("나이 : " + dto.getAge());
		System.out.println("주소 : " + dto.getAddr());
		
		//기능 완료 한 후 session or application or response 필요하다면??
		session.setAttribute("time", new Date().toLocaleString()); //${sessionScope.time}
		ServletContext application = session.getServletContext();
		application.setAttribute("fileName", "test.txt"); //${applicationScope.fileName}
	}
	
	/**
	 * 현재 Controller를 들리는 요청들이 결과 뷰에서 공통으로
	 * 사용하게 될 정보 저장하기 
	 * */
	@ModelAttribute("message") //${message}
	public String aa() {
		return "벌써 배고프다..";
	}
	
	@ModelAttribute("fruits") //${fruits}
	public List<String> bb(){
		List<String> list = new ArrayList<String>();
		list.add("사과");
		list.add("구름");
		list.add("딸기");
		list.add("배");
		return list;
	}
	
	/**
	 * @RequestParam은 
	 * parameter로 전달되는 name과 인수의 이름이 다를 떄 
	 * 설정을 통해 매칭 시켜줄 수 있다. ex) value="id"
	 * 
	 * @RequestParam을 선언하면 자동으로 required="true"로 설정되어 
	 * 필수 요소로 설정된다.
	 * */
	@RequestMapping("/d.do")
	public String dd(@RequestParam(value = "id",required = false) String userId,
			@RequestParam(value = "name",defaultValue = "Guest") String userName,
			@RequestParam(defaultValue = "0") int age) {
		System.out.println("userId : " + userId);
		System.out.println("userName : " + userName);
		System.out.println("age : " + age);
		return "paramResult";
	}
	

}
