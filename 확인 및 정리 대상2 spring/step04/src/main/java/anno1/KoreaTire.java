package anno1;

import org.springframework.stereotype.Component;
//@Component 인 경우 : bean의 이름이 default는 koreaTire로 자동설정
//<bean id="test" class="anno1.KoreaTire" /> 와 동일, 자동 등록
@Component("test")
public class KoreaTire  implements Tire{
	@Override
	public String getBrand() {		
		return "금호 타이어";
	}
}
