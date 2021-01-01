package org.kosta.mvc.aspect;

import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;


@Service
@Aspect
public class SessionCheckAdvice {
	/**
	 * Board의 검색, 등록, 수정, 삭제, 상세보기 클릭하기 전에
	 * 세션유무체크하여 세션이 없으면 예외 발생한다.
	 * (즉, Board는 로그인된 사용자만 접근가능)
	 * */
	@Before("execution(public * org.kosta.mvc.board.controller.Board*.*(..))")
	public void before(JoinPoint point) {
		//세션유무체크한다.
		Object obj [] = point.getArgs();//타겟 대상(joinpoint)의 매소드 인수
		HttpSession session = (HttpSession)obj[0];
		if(session == null || session.getAttribute("loginUser") == null){
			throw new RuntimeException("로그인하고 이용해주세요.");
		}
	}
}
