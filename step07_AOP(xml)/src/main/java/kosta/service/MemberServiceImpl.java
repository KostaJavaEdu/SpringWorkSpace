package kosta.service;

public class MemberServiceImpl implements MemberService {

	@Override
	public void register(int no, String name) throws Exception {
		System.out.println("register(int no, String name) 의 핵심기능 입니다.");
		if(no == 0) throw new Exception("예외가 발생했어요");
	}

	@Override
	public boolean update(String id) {
		System.out.println("update(String id) 의 핵심기능 입니다.");
		return false;
	}

}
