
public class Salary {
	private String name;
	private int salary;	
	
	Salary(String name, int salary){
		this.name = name;
		this.salary = salary;
	}	// 생성자가 생성된다면, default 값은 없음
		// class는 만들어 지자 마자 생성자가 생김.
		// 매개변수가 없는 것은 신경안써도 되지만
		// 매개변수가 있는 경우 호출해줘야 합니다.
	
	void viewInformation(){		// 이름과 연봉을 출력
		System.out.println("이름 : "+name);
		System.out.println("연봉 : "+salary);
		
	}
	
}
