
public class Department extends Salary { // Salary 를 상속받음
	private String department;
	
	Department(){
		super(null, 0);
		System.out.println("생성자 호출");
		// super 위쪽에는 명령어가 오면 안된다.
	}
	
	Department(String name, int salary, String department){
		
		super(name, salary); 
		//this(); this 와 super 위에는 명령어가 오면 안됨
		// this / super는 한가지만 써야 합니다.
		// super(); 상속관계에 있는 default 생성자 함수 값
	// 부모 생성자 호출
		
		this.department = department;	// 부모 생성자로
	}
	
	void viewInformation() {	// => 부서 출력
		super.viewInformation();
		// super는 부모 클래스를 나타냅니다.
		// 부모class 함수명이 같은 경우 super로만
		// 호출할 수 있다.
		System.out.println("부서 : "+department);
		
	}
	
}
