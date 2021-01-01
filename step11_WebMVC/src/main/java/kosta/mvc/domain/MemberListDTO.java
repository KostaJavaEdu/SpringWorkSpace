package kosta.mvc.domain;

import java.util.List;

public class MemberListDTO {
	private List<MemberDTO> list; // <input name="list[index]">.속성
	
	public MemberListDTO() {
		System.out.println("MemberListDTO 생성자 호출됨...");
	}

	public List<MemberDTO> getList() {
		return list;
	}

	public void setList(List<MemberDTO> list) {
		this.list = list;
		System.out.println("setList(List<MemberDTO> list) 호출 : " + list);
	}
	
	
}
