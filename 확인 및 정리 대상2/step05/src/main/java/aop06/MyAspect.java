package aop06;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect {
	@Pointcut("execution(* classWork())")
	public void myClass() {
		
	}
	@Before("myClass()")
	public void before(JoinPoint joinPoint) {
		System.out.println("교실문을 연다.");
	}
	@After("myClass()")
	public void after(JoinPoint joinPoint) {
		System.out.println("교실문을 잠근다.");
	}
	
}
