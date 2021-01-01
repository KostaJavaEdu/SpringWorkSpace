package kosta.advice;

import org.aspectj.lang.annotation.Pointcut;

public class PointCutClass {
	
	@Pointcut("execution(public * kosta.service.*Impl.*(..))")
	public void pointCut() {}
	
	
}
