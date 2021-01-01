package sample07;

public class MemberController {
	private MemberVO memberVO;
	
	private MemberVO memberVO2;
	
	public MemberController() {
		System.out.println("MemberController()기본생성자 호출됨");
	}
	
	public MemberController(MemberVO memberVO, MemberVO memberVO2) {
		this.memberVO = memberVO;
		this.memberVO2 = memberVO2;
		System.out.println("MemberController(MemberVO memberVo, MemberVO memberVO2) 호출됨..");
		System.out.println("memberVO : " + memberVO);
		System.out.println("memberVO2 : " + memberVO2);
		
		System.out.println("이름 : " + memberVO.getName());
		System.out.println("이름 : " + memberVO2.getName());
		
	}
	
	
	public void setMemberVO(MemberVO memberVO) {
		this.memberVO = memberVO;
		System.out.println("setMemberVO(MemberVO memberVO) 호출됨.. memberVO" + memberVO);
		System.out.println("이름 : " + memberVO.getName());
	}
	
	public void setMemberVO2(MemberVO memberVO2) {
		this.memberVO2 = memberVO2;
		System.out.println("setMemberVO2(MemberVO2 memberVO2) 호출됨.. memberVO2" + memberVO2);
		System.out.println("이름 : " + memberVO2.getName());
	}
}
