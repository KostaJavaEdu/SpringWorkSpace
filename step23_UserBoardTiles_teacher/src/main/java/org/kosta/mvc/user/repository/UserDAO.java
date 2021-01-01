package org.kosta.mvc.user.repository;

import org.kosta.mvc.user.domain.Member;

public interface UserDAO {
  /**
   * 로그인 기능
   * */
	Member loginCheck(Member userDTO);
}
