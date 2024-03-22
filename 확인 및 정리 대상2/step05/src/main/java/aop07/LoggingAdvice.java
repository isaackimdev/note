package aop07;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

// 횡단(공통)관심 사항
public class LoggingAdvice {
	// 매개변수로 호출을 가로챈 함수를 전달받는다.
	public void logAround(ProceedingJoinPoint joinPoint) throws Throwable {	// 예외 전가 
		// 호출을 가로챈 함수의 이름 얻어오기
		String methodName = joinPoint.getSignature().getName();
		StopWatch sw = new StopWatch();
		System.out.println("From [applicationContext.xml");
		System.out.println("[LOG]METHOD : " + methodName + "is Calling");
		sw.start();
		joinPoint.proceed();	// 이 명령어를 기준으로 before, after : 핵심관심사항
		sw.stop();
		
		System.out.println("[LOG]METHOD : " + methodName + "was done");
		System.out.println("[LOG]처리시간 : " + sw.getTotalTimeMillis()/1000 + "초");
	}
}
