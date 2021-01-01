package kosta.mvc.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kosta.mvc.model.vo.Authority;
@Repository
public class AuthoritiesDAOImpl implements AuthoritiesDAO {
	
	@Autowired
	private SqlSession session;

	@Override
	public int insertAuthority(Authority authority) {
		int result = session.insert("authoritiesMapper.insertAuthority", authority);
		return result;
	}

	@Override
	public List<Authority> selectAuthorityByUserName(String userName) {
		List<Authority> list = session.selectList("authoritiesMapper.selectAuthorityByUserName", userName);
		return list;
	}

}
