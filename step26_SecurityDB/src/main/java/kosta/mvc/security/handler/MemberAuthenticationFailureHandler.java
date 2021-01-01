package kosta.mvc.security.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Service;

@Service //id="memberAuthenticationFailureHandler"
public class MemberAuthenticationFailureHandler implements AuthenticationFailureHandler {
	
	/**
	 * 인증에 실패 했을 때 onAuthenticationFailure 가 호출된다.
	 * */
	
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		
		request.setAttribute("errorMessage", exception.getMessage());
		//request.getRequestDispatcher("/WEB-INF/views/member/loginForm.jsp").forward(request, response);
		
		request.getRequestDispatcher("/member/loginForm").forward(request, response);
	}
}
