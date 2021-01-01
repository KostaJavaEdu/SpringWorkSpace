package sample06;

public class Customer {
	private String id;
	private int age;
	private String addr;
	
	public Customer() {
		System.out.println("Customer() 기본생성자 호출..");
	}

	public Customer(String id) {
		System.out.println("Customer(String id) 기본생성자");
		this.id = id;
	}

	public void setId(String id) {
		this.id = id;
		System.out.println("setId(String id) 호출됨 id : " + id);
	}

	public void setAge(int age) {
		this.age = age;
		System.out.println("setAge(int age) 호출됨 age : " + age);
	}

	public void setAddr(String addr) {
		this.addr = addr;
		System.out.println("setAddr(String addr) 호출됨 addr : " + addr);
	}
	
	
}
