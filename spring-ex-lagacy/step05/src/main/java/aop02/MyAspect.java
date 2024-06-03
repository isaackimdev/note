package aop02;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MyAspect implements MethodInterceptor {	//상속

	@Override								// pointcut 포인트 컷을 전달 받음
	public Object invoke(MethodInvocation invocation) throws Throwable {
		Object returnValue = null;			// 공통관심사항
		// 대상 메서드 실행전
		System.out.println("교실문을 연다.");
		try {
			// 대상 메서드 실행
			returnValue = invocation.proceed();	// 핵심 관심사항을 삽입 시킴
		} catch (Exception e) {
			// 대상 객체 메서드 실행 중 Exception 발생 시 코드
			System.out.println("** 오늘은 소독하는 날 **");
		} finally {
			// 대상 객체 메서드 실행 후 코드
			System.out.println("전등이 꺼져 있는지 확인한다.");
		}
		// 대상 메서드 실행 후  
		System.out.println("교실문을 잠근다.");
		
		return returnValue;
	}

}
