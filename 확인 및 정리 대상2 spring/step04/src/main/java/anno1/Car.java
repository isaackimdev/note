package anno1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component 인 경우 : bean의 이름이 default는 car로 자동 설정
//<bean id="carTire" class="anno1.Car" /> 와 동일, 자동 등록
@Component("carTire")
public class Car {
	// Autowired 어노테이션이 붙은 인스턴스 변수는 해당 변수 타입과  
	// 일치하는 컨텍스트 내의 빈을 찾아 인스턴스 변수에 주입해 준다.
	// 	<property name="tire" ref="test"/>
	@Autowired
	private Tire tire;

	public Car() {
		super();
		System.out.println("Car() 호출");
	}	
	public Car(Tire tire) {
		super();
		this.tire = tire;
		System.out.println("Car(Tire tire) 호출");
	}	
	public void setTire(Tire tire) {
		this.tire = tire;
		System.out.println("setTire(Tire tire) 호출");
	}
	public void driver() {
		System.out.println(tire.getBrand() + "로 만들어진 국산 자동차");
	}
}








