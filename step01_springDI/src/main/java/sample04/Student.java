package sample04;

public class Student {
	private String name;
	private int no;
	private String phone;
	private String addr;
	
	public Student() {
		System.out.println("Student() 기본생성자 호출...");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		System.out.println("setName(String name) 호출됨... : " + name);
		this.name = name;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		System.out.println("setNo(int no) 호출됨... : " + no);
		this.no = no;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		System.out.println("setPhone(String phone) 호출됨... : " + phone);
		this.phone = phone;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		System.out.println("setAddr(String addr) 호출됨... : " + addr);
		this.addr = addr;
	}
}
