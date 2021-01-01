package sample02;

public class MemberDAO {
	public MemberDAO() {
		System.out.println("MemberDAO() 생성자 호출됨...");
	}
	public void insert(Member member) {
		System.out.println("MemberDAO의 insert호출됨...");
		System.out.println("member : " + member);
	}
}
