package kosta.advice;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 사전 ,사후 처리
 * */
public class AroundAdvice {
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("around의 사전처리 입니다.\n");
		Object obj = joinPoint.proceed(); // 실제 타겟대상 호출(register, update call)
		System.out.println("around의 사후처리 입니다.\n");
		return obj;
	}
}
