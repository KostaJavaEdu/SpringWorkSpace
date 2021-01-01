package sample10;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("sample10/springAnnotation.xml");
		
		BoardController controller = 
				context.getBean("boardController",BoardController.class);
		
		controller.test();
	}

}
