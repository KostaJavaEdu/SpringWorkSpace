package kosta.exam;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

/**
 * 공통의 기능을 담당하게 될 Aspect
 * 
 * 	- Around방식 : 
 * 		사전 : 현재 시간 구하기
 * 		사후 : 현재 시간 구하기, 사후시간 - 사전시간 = 두 gap
 * 
 * 		join point를 상속한 ProceedingJoinPoint
 * 			- JoinPoint interface는  target대상에 대한 기본 정보를 제공하는
 * 			  메소드들이 있다.
 * 
 * 		@param : ProceedingJoinPoint
 * 					- 실제 target대상을 호출할 수 있는 메소드 제공.
 * */
public class TimerAdvice {
	
	public  Object around(ProceedingJoinPoint joinPoint) throws Throwable{
		//사전
		//target대상 메소드 이름 구하기
		String methodName = joinPoint.getSignature().getName();
		System.out.println("[LOG]"+methodName+"호출 되기 전.....");
		
		StopWatch sw = new StopWatch();
		sw.start();
		
		//실제 타켓대상(join point) 호출
		Object obj = joinPoint.proceed();
		
		//사후
		sw.stop();
		System.out.println("[LOG]" + methodName+"의 리턴값 : "+ obj);
		System.out.println("[LOG]" + methodName+"의 총 실행시간 : "+sw.getTotalTimeMillis());
		System.out.println("[LOG]" + methodName + "의 호출완료\n");
		
		return obj;
	}
}
