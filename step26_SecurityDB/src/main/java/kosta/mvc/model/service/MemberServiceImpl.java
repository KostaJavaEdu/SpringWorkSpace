package kosta.mvc.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kosta.mvc.model.dao.AuthoritiesDAO;
import kosta.mvc.model.dao.MemberDAO;
import kosta.mvc.model.vo.Authority;
import kosta.mvc.model.vo.Member;
import kosta.mvc.util.Constants;
@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberDAO memberDAO;
	
	@Autowired
	private AuthoritiesDAO authoritiesDAO;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	@Transactional
	public int joinMember(Member member) {
		
		//가입 전에 비밀번호 평문을 암호화 해서 저장한다.
		String pwd = passwordEncoder.encode(member.getPassword());
		member.setPassword(pwd);
		
		//가입하기
		int result = memberDAO.insertMember(member);
		if(result == 0) throw new RuntimeException("가입되지 않았습니다."); //예외처리...
		
		//UserType에 따른 권한 등록
		result = authoritiesDAO.insertAuthority(new Authority(member.getId(), Constants.ROLE_MEMBER));
		
		if(member.getUserType()==null) {
			throw new RuntimeException("권한 등록 오류로 Rollback 처리됩니다.");
		}
		
		if(member.getUserType().equals("1")) {
			result = authoritiesDAO.insertAuthority(new Authority(member.getId(), Constants.ROLE_ADMIN));
		}
		return result;
	}
}