package kosta.test.advice;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

public class LogAdvice {
	
	Log log = LogFactory.getLog(this.getClass());
	
	public LogAdvice() {}
	
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable{
		//사전
		//target대상 메소드 이름 구하기
		
		String methodName = joinPoint.getSignature().getName();
		
		StopWatch sw = new StopWatch();
		sw.start();
		
		//실제 타켓대상(join point) 호출
		Object obj = joinPoint.proceed();
		
		//사후
		sw.stop();
		log.info(methodName +"호출 / 인수갯수 : "+ joinPoint.getSignature().getModifiers() +
				"/ 리턴값 :"+obj+"/ 총실행시간 : "+sw.getTotalTimeMillis());
		
		System.out.println(methodName +"호출 / 인수갯수 : "+ joinPoint.getSignature().getModifiers() +
				"/ 리턴값 :"+obj+"/ 총실행시간 : "+sw.getTotalTimeMillis());
		
		return obj;
	}
}
