package aop06;

import org.springframework.stereotype.Component;
//<bean id="woman" class="aop06.Woman" />와 동일, 자동 등록
@Component
public class Woman implements Person{

	@Override
	public void classWork() {
		System.out.println("컴퓨터를 켜고 Shopping을 시작한다.");
	}

}
