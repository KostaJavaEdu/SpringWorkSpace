package kosta.exam;

import org.springframework.aop.framework.AopContext;

public class MessageServiceImpl implements MessageService {

	@Override
	public void korHello() {
		System.out.println("MessageServiceImpl 의 korHello() 핵심기능입니다.");
		
		System.out.println("#################");
		//현재 AOP proxyServer 구하기
		MessageService service = (MessageService)AopContext.currentProxy();
		service.engHello();
		//this.engHello();
		System.out.println("#################");
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void engHello() {
		System.out.println("MessageServiceImpl 의 engHello() 핵심기능입니다.");
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	@Override
	public String hello() {
		System.out.println("MessageServiceImpl 의 hello() 핵심기능입니다.");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "반가워";
	}

	@Override
	public int hello(String name) {
		System.out.println("MessageServiceImpl 의 hello(String name) 핵심기능입니다.");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return 5;
	}

}
