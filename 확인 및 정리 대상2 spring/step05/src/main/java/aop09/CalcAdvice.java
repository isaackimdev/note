package aop09;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class CalcAdvice {
	// 포인트컷 설정 함수
	// 실행시킬 핵심사항 함수를 정의한다.
	@Pointcut("execution(public * *(..))")
	public void myCalc() {	
	}
	// 핵심사항 함수 실행 전/후에 실행
	@Around("myCalc()")
	public void around(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("** 연산 시작 **");
		pjp.proceed();
		System.out.println("** 연산 종료 **\n\n");
	}
}

