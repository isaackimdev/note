
public class Member {
	String name;
	int age;
	// 기본 함수 : 기보적인 기능을 하는 함수
	// 생성자, getter, setter
	String getName() {			// getter : 멤버변수에 저장된 값 확인
		return name;			// 클래스 박에서 확인하고 싶을 떄,
	}
	void setName(String name) {	// setter : 멤버변수에 데이터 저장
		this.name = name;		// 클래스 밖에서 안쪽의 값에 저장할 떄,
	}
	int getAge() {
		return age;
	}
	void setAge(int age) {
		this.age = age;
	}
	void output() {
		System.out.println(this.getName());
		System.out.println(this.getAge());
	}
}
