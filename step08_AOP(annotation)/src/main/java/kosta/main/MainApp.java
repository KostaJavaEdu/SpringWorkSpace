package kosta.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kosta.service.MemberService;

public class MainApp {

	public static void main(String[] args) {
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("kosta/advice/applicationContext.xml");
		
		MemberService service = context.getBean("target",MemberService.class);
		try {
			service.register(10, "수녕");
		} catch (Exception e) {
			System.out.println("-----예외-----");
		}
	}
}
