package org.kosta.mvc.user.service;

import org.kosta.mvc.user.domain.Member;
import org.kosta.mvc.user.repository.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO userDAO;
	
	@Override
	public Member loginCheck(Member member){
		Member memberDTO = userDAO.loginCheck(member);
		if(memberDTO==null) throw new RuntimeException("아이디 비밀번호가 틀렸습니다.");
		else return memberDTO;
	}
}
