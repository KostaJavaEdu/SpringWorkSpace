package org.kosta.mvc.user.repository;

import org.apache.ibatis.annotations.Select;
import org.kosta.mvc.user.domain.Member;

public interface UserMapper {
	@Select("select user_id, pwd, name from member where user_id=#{userId} and pwd=#{pwd}")
   Member loginCheck(Member member);
}
