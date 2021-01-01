package kosta.exam;

public class UserService {
	public boolean testHello() {
		System.out.println("UserService의 testHello() 핵심기능 입니다.");
		try {
			Thread.sleep(1300);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return true;
	}
	public int insertHello(String name) {
		System.out.println("UserService의 insertHello(String name) 핵심기능 입니다.");
		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return 10;
	}
}
