package kosta.mvc.domain;

public class MemberDTO {
	private String id;
	private String name;
	private int age;
	private String addr;
	
	private boolean state;
	
	public MemberDTO() {}
	
	public MemberDTO(String id, String name, int age, String addr) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.addr = addr;
	}
	

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
		System.out.println("setState(boolean state) 호출 : " + state);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
		System.out.println("setId(String id) 호출 : "+id);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		System.out.println("setName(String name) 호출 : "+ name);
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
		System.out.println("setAge(int age) 호출 : " + age);
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
		System.out.println("setAddr(String addr) 호출 : " + addr);
	}
}
