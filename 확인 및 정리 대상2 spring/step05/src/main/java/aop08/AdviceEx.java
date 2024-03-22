package aop08;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class AdviceEx {
	@Around("execution(* zeroMethod(..))")
	public void around(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("Joinpoint 양쪽의 전에 실행되는 Advice");
		joinPoint.proceed();
		System.out.println("Joinpoint 양쪽의 후에 실행되는 Advice");		
	}
	@Before("execution(* zeroMethod(..))")
	public void before() {
		System.out.println("Joinpoint 앞에서 실행되는 Advice");
	}
	@After("execution(* zeroMethod(..))")
	public void after() {
		System.out.println("Joinpoint 뒤에서 실행되는 Advice");
	}
	@AfterThrowing(pointcut="execution(* zeroMethod(..))", throwing="e")
	public void afterthrowing(Throwable e) {
		System.out.println("예외가 실행될 때 호출되는 Advice");
		System.out.println(e.getMessage());
	}
	@AfterReturning(pointcut="execution(* zeroMethod(..))", returning="ret")
	public void afterReturning(Object ret) {
		System.out.println("Joinpoint가 정상 종료후 실행되는 Advice");
	}
}
