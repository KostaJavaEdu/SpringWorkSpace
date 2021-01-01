package kosta.exam;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("kosta/exam/applicationContext.xml");
		
		/**
		 * AOP proxyServer는 기본 interface를 기반으로 생성된다.
		 * 	: interface를 구현한 구현 객체에 advice를 적용 할때는 
		 * 	  반드시 interface를 통해 메소드를 호출해야 proxyserver를 생성할 수 있다. - J2SE기반
		 *    만약 설정에서 proxy-target-class="true" 를 성정하면 
		 *    CGLIB 방식으로 proxyServer를 생성한다.
		 *    이렇게 하면 interface이든 아니든 상관 없이 적용가능.
		 * */
		
//		MessageServiceImpl service = 
//				context.getBean("target",MessageServiceImpl.class); //이렇게 쓰고싶으면 proxy-target-class="true"로 바꿔줘
		
		MessageService service = 
				context.getBean("target",MessageService.class);
		
		//service.engHello();
		
		System.out.println("------------------");
		service.korHello();
		
		System.out.println("------------------");
		service.hello();
		
		System.out.println("------------------");
		service.hello("수녕");
		
		System.out.println("======================");
		UserService user = 
				context.getBean("userService",UserService.class);
		user.testHello();
		
		System.out.println("*********************");
		user.insertHello("최수녕");
	}

}
