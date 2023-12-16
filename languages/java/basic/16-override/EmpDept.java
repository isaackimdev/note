
public class EmpDept extends Emp {
		
	String department = "";		// 초기값 : " 홍보부 "
	
	public EmpDept() {
		department = "홍보부";
	}
	@Override
	void viewDisplay(){		// 부서 출력
		super.viewDisplay();
		System.out.println("부서 : "+department);
	}
}
