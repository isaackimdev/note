package anno1;

import org.springframework.stereotype.Component;
//@Component 인 경우 : bean의 이름이 default는 koreaTire로 자동설정
//<bean id="test" class="anno1.KoreaTire" /> 와 동일, 자동 등록
@Component("test")
public class KoreaTire implements Tire {
	
	@Override // Tire를 상속받았기에 override
	public String getBrand() {		
		return "금호타이어";
	}
}
