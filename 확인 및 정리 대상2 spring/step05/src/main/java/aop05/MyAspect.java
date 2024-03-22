package aop05;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class MyAspect {
	// 실행시킬 핵심사항 함수를 정의한다.
	@Pointcut("execution(* classWork())")
	public void myClass() {	
		
	}
	// 핵심사항 함수 실행 전에 실행
	@Before("myClass()")
	public void before(JoinPoint joinPoint) {
		System.out.println("교실문을 연다.");
	}
	// 핵심사항 함수 실행 후에 실행
	@After("myClass()")
	public void after(JoinPoint joinPoint) {
		System.out.println("교실문을 잠근다.");
	}
}
