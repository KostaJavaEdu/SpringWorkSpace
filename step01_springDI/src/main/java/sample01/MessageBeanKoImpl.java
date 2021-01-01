package sample01;

public class MessageBeanKoImpl implements MessageBean {

	public MessageBeanKoImpl() {
		System.out.println("MessageBeanKoImpl생성자 호출됨...");
	}
	
	@Override
	public void sayHello(String name) {
		System.out.println(name+"님 방가방가");
	}

}
