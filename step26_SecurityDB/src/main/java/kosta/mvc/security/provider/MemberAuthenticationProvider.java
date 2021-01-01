package kosta.mvc.security.provider;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import kosta.mvc.model.dao.AuthoritiesDAO;
import kosta.mvc.model.dao.MemberDAO;
import kosta.mvc.model.vo.Authority;
import kosta.mvc.model.vo.Member;

@Service //id="memberAuthenticationProvider"
public class MemberAuthenticationProvider implements AuthenticationProvider {
	
	@Autowired private MemberDAO memberDAO;
	@Autowired private AuthoritiesDAO authoritiesDAO;
	@Autowired private PasswordEncoder passwordEncoder;
	
	/**
	 * 사용자가 인증을 위해 id, pwd를 입력해서 전송하면
	 * Authentication를 만들어서 authenticate()메소드의 매개변수로 전달해준다.
	 * 
	 * 전달된 매개변수(Authentication)에서 id(userName)를 꺼낸다.
	 * 꺼낸 id에 해당하는 회원정보를 DB에서 검색한다.
	 * DB에 정보가 있다면 DB에 있는 암호화 된 비밀번호와 인수로 전달 된 
	 * 평문비밀번호를 서로 비교한다. - PasswordEnocder 필요
	 * 
	 * 만약, 일치하지 않으면 예외를 발생시켜
	 * AuthenticationFailureHandler가 실행되게 한다.
	 * 
	 * 모두 일치한다면 인증된 사용자의 정보와 그 사용자의 권한을 
	 * Authentication에 저장하고 리턴한다. - UsernamePasswordAuthenticationToken
	 * */
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		//아이디 꺼내기
		String id = authentication.getName();//입력된 id
		Member member = memberDAO.selectMemberById(id);
		if(member==null) throw new UsernameNotFoundException("아이디 또는 비밀번호를 확인해주세요.");
		
		//비밀번호 비교
		String inputPwd = authentication.getCredentials().toString();
		if(!passwordEncoder.matches(inputPwd, member.getPassword())) {
			throw new UsernameNotFoundException("정보를 다시 확인해주세요 ");
		}
		
		//인증 성공하였으니 모든 권한을 검색한다.
		List<Authority> authList = authoritiesDAO.selectAuthorityByUserName(id);
		List<SimpleGrantedAuthority> list = new ArrayList<SimpleGrantedAuthority>();
		for( Authority auth : authList ) {
			String role = auth.getRole();
			list.add(new SimpleGrantedAuthority(role));
		}
		return new UsernamePasswordAuthenticationToken(member, null, list);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		
		return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
	}
}
