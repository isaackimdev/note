package aop06;

import org.springframework.stereotype.Component;
// <bean id="man" class="aop06.Man" />와 동일, 자동 등록
@Component
public class Man implements Person{

	@Override
	public void classWork() {	
		System.out.println("컴퓨터를 켜고 Game을 시작한다.");
	}
	

}
