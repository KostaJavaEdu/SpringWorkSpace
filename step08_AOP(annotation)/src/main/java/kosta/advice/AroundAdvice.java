package kosta.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

/**
 * 사전 ,사후 처리
 * */
@Service //id="aroundAdvice"
@Aspect
@Order(2)
public class AroundAdvice {

	
	@Around("PointCutClass.pointCut()")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("around의 사전처리 입니다.\n");
		Object obj = joinPoint.proceed(); // 실제 타겟대상 호출(register, update call)
		System.out.println("around의 사후처리 입니다.\n");
		return obj;
	}
}
