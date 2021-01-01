package sample01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		//1. 기존방식으로 호출
//		MessageBean bean = new MessageBeanEnImpl();
//		bean.sayHello("snsn");
//		
//		System.out.println("-------------------------");
//		
//		bean = new MessageBeanKoImpl();
//		bean.sayHello("수녕");
		
		/////////////////////////////////////////////
		/*
		 * 2. spring Container를 이용한 객체 주입
		 * 	: BeanFactory : 기본 객체 생성과 소멸 관리
		 * 	: ApplicationContext - BeanFactory의 확장으로 
		 * 		BeanFactory의 기능 + 다국어지원, 메시지 처리 등등
		 * 		더 많은 기능을 제공한다.
		 * 		
		 * 		*특징
		 * 		  - 객체를 사전 초기화(미리 메모리에 생성, 쓰고 안쓰고의 문제가 아니라 이미 객체가 생성됨)
		 * 		  - getBean을 여러번 호출해도 동일한 객체를 사용한다(singleton pattern).(static과 비슷)
		 * 		  - bean을 만들때 scope="prototype" 옵션을 설정하면 
		 * 			지연 초기화(getBean을 할 때마다 새로운 객체를 생성해준다.)
		 * */
		ApplicationContext context = 
				//new ClassPathXmlApplicationContext("sample01/applicationContext.xml"); //classpath기준으로 가져옴
				new FileSystemXmlApplicationContext("src/main/java/sample01/applicationContext.xml"); //project기준으로 가져옴 (권장하진 않음)
		
		
		//필요한 객체 가져오기
		MessageBean bean1 = context.getBean("ko",MessageBean.class);
		bean1.sayHello("수녕");
		
		System.out.println("--------------------");
		
		MessageBean bean2 = context.getBean("en",MessageBean.class);
		bean2.sayHello("snsn");
		
		
		MessageBean bean3 = context.getBean("en",MessageBean.class);
		bean3.sayHello("good~~~"); 
		
		System.out.println("주소출력");
		System.out.println("bean1 : "+bean1);
		System.out.println("bean2 : "+bean2);
		System.out.println("bean3 : "+bean3);
	}
}
