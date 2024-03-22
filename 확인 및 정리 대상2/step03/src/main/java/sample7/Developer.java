package sample7;

public class Developer extends Emp {
	private String dept;

	public Developer() {
		super();
	}

	public Developer(String name, int salary) {
		super(name, salary);
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return super.toString() +  ", 부서 = " + dept + "(개발부)";
	}
	
	
	
}
