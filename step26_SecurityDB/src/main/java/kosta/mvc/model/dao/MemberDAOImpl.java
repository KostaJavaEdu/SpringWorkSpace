package kosta.mvc.model.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kosta.mvc.model.vo.Member;
@Repository
public class MemberDAOImpl implements MemberDAO {
	
	@Autowired
	private SqlSession session;

	@Override
	public int insertMember(Member member) {
		int result = session.insert("memberMapper.insertMember", member);
		return result;
	}

	@Override
	public Member selectMemberById(String id) {
		Member member = session.selectOne("memberMapper.selectMemberById",id);
		return member;
	}

}
