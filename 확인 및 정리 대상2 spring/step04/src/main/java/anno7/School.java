package anno7;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
//<bean id="mySchool" class="anno4.School" /> 와 동일, 자동 등록
@Component("mySchool")
public class School {
	@Autowired
	Student person;
	// name 속성에 자동으로 연결될 빈 객체의 이름을 입력
	//@Resource(name="grade")
	@Autowired
	int grade;
	
	@Override
	public String toString() {
		return "School [person=" + person + ", grade=" + grade + "]";
	}							// person.toString() 생략되어있음
	
}
