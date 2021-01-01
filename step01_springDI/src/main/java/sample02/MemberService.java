package sample02;

public class MemberService {
	
	private MemberDAO memberDAO;
	private Member member;
	
	public MemberService() {
		System.out.println("MemberService() 기본생성자 호출...");
	}
	
	
	
	public MemberService(MemberDAO memberDAO, Member member) {
		this.memberDAO = memberDAO;
		this.member = member;
		
		System.out.println("MemberService(MemberDAO memberDAO, Member member) 호출...");
		System.out.println("memberDAO = " + memberDAO);
		System.out.println("member = " + member);
	}



	public void insert() {
		//dao의 insert호출...
		//MemberDAO dao = new MemberDAO();
		//dao.insert(member);
		memberDAO.insert(member);
		
	}
}
