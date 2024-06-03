package aop04;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
/**
 * 
 * @author 어노테이션
 * 설정파일에서 advice 및 ㅁpointcut 등을 설정하지 않고 자동적으로 advice를 적용
 */
@Aspect
public class MyAspect {
	// 공통관심사항
	
	// 메소드 이름의 범위를 정의한다. (aop04폴더 안의 파일이름을 정의)
	// @Before("execution(public void aop04.Woman.classWork())") 형식으로 사용
	@Before("execution(public void aop04.*.*(..))")
	public void before(JoinPoint joinPoint) {
		System.out.println("교실문을 연다.");
	}
	@After("execution(public void aop04.*.*(..))")
	public void after(JoinPoint joinPoint) {
		System.out.println("교실문을 잠근다.");
	}
	// 예외가 발생하는 경우에 실행
	@AfterThrowing(pointcut="execution(public void aop04.*.*(..))", throwing="e")
	public void throwing(JoinPoint joinPoint, Throwable e) {
		System.out.println("** 오늘은 소독하는 날 **/n" + e.getMessage());
	}
	
}
