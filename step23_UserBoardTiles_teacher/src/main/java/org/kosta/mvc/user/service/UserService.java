package org.kosta.mvc.user.service;

import org.kosta.mvc.user.domain.Member;

public interface UserService {
	/**
	 * 로그인 체크
	 * */
   Member loginCheck(Member userDTO);
}
