package org.kosta.mvc.user.repository;

import org.kosta.mvc.user.domain.Member;

public interface UserDAO {
  /**
   * �α��� ���
   * */
	Member loginCheck(Member userDTO);
}
