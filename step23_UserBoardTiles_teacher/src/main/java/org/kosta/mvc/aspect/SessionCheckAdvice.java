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
    * Board/* �� �˻�, ���, ����, ����, �󼼺��� Ŭ���ϱ�����
    * ��������üũ�Ͽ� ������ ������ ���ܹ߻��Ѵ�.
    * (��, Board�� �α��ε� ����ڸ� ���� ����)
    * 
    * */
	@Before("execution(public * org.kosta.mvc.board.controller.Board*.*(..))")
	public void before(JoinPoint point ) {
		//��������üũ�Ѵ�.
		Object obj [] = point.getArgs();//target�����(joinPoint)�� �޼ҵ� �μ�
		HttpSession session = (HttpSession)obj[0];	
		if(session == null ||  session.getAttribute("loginUser") == null) {
			throw new RuntimeException("�α����ϰ� �̿����ּ���^^");
		}
		
	}
}






