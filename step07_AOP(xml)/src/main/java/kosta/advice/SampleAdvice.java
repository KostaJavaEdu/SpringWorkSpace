package kosta.advice;

import org.aspectj.lang.JoinPoint;

public class SampleAdvice {
	/**
	 * 사전처리 (Before)
	 * 
	 * @param : JoinPoint는 호출되어지는 메소드의 정보 제공받기 위해 필요
	 * */
	public void before(JoinPoint joinPoint){
		String methodName = joinPoint.getSignature().getName();
		int len = joinPoint.getArgs().length;
		System.out.println(methodName+"의 인수의 개수 : " + len);
		for( Object o : joinPoint.getArgs()) {
			System.out.println(methodName+"의 인수 : " + o);
		}
		System.out.println(methodName+"호출되기 전 before....");
	}
	/**
	 * 사후처리 - 예외발생 여부 상관없이
	 * */
	public void afterFinally() {
		System.out.println("afterFinally() 예외 발생여부 없이 호출됩니다.");
	}
	
	/**
	 * 사후처리 - 예외발생 없이 정상적으로 동작했을 때...
	 * 
	 * @param : obj변수는 타겟 대상이 실행된 후 리턴되어지는 값을 전달받을 매개변수이다.
	 * 			설정문에서 returning="obj"가 필요하다.
	 * */
	public void afterReturning(JoinPoint joinPoint, Object obj) {
		String methodName = joinPoint.getSignature().getName();
		System.out.println(methodName+"의 리턴값은 : " + obj);
		
		System.out.println(methodName+"가 예외없이 정상적으로 동작했어요");
	}
	
	/**
	 * 사후처리 - 예외 발생 하였을때...
	 * 
	 * @param : Throwable매개변수는 예외 발생했을 때 발생한 예외에 대한 정보를 전달 받기 위해서 선언한다.
	 * 			설정 문서에서 throwing="e" 필요하다.
	 * */
	public void afterThrowing(Throwable e) {
		System.out.println("afterThrowing(Throwable e) 예외 발생 했을 때 : " + e);
	}
}
