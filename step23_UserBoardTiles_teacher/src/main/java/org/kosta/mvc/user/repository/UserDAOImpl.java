package org.kosta.mvc.user.repository;

import org.apache.ibatis.session.SqlSession;
import org.kosta.mvc.user.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SqlSession session;
	
	@Override
	public Member loginCheck(Member userDTO) {
		UserMapper mapper = session.getMapper(UserMapper.class);
		Member member = mapper.loginCheck(userDTO);
		return member;
	}

}



