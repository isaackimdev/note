package sample8;

public class Developer {
	private Emp emp;
	private String dept;
	
	public Developer() {
		super();
	}

	public Developer(Emp emp) {
		super();
		this.emp = emp;
		this.dept = dept;
	}
	public Developer(Emp emp, String dept) {
		super();
		this.emp = emp;
		this.dept = dept;
	}
	// dept만 getter setter 만들어줌
	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return emp.toString() + ", 부서 = " + dept + "(개발부)";
	}
	
	
}
