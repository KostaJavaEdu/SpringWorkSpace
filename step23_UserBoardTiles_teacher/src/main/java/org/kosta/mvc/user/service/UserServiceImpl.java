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
	public Member loginCheck(Member userDTO) {
		Member member = userDAO.loginCheck(userDTO);
		if(member==null) throw new RuntimeException("���̵�� ��й�ȣ Ȯ���ϼ���.");
		return member;
	}

}
