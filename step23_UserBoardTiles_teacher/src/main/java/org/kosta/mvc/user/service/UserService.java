package org.kosta.mvc.user.service;

import org.kosta.mvc.user.domain.Member;

public interface UserService {
	/**
	 * �α��� üũ
	 * */
   Member loginCheck(Member userDTO);
}
