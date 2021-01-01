package sample02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		//기존방식
		//Member member = new Member("11", "11");
		
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("sample02/springDiConstructor.xml");
		
		System.out.println("----------------------------");
		//서비스의 insert호출
		MemberService service = context.getBean("service", MemberService.class);
		service.insert();
		
		System.out.println("-----------------------");
		
//		Member member = new Member(id,pwd,age,addr);
//		MemberDAO dao = new MemberDAO();
//		MemberService service = new MemberService(memberDAO,member);
//		service.insert(dao,member);
		
	}

}
