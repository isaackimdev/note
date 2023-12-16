
public class Emp {
	private String name = "";	// 초기값  : 개나리
	private int salary = 0 ; 	// 초기값 : 12 000 000

	public Emp(){
		name = "개나리";
		salary = 12000000;
	}
	
		
	void viewDisplay() {	//	이름과 연봉출력
		System.out.println("이름 : " + name);
		System.out.println("연봉 : " + salary);
		
	}
	
}
