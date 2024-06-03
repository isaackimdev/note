package sample8;

public class Emp {
	private String name;
	private int salary;
	
	public Emp() {
		super();
	}
	public Emp(String name, int salary) {
		super();
		this.name = name;
		this.salary = salary;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "이름 = " + name + ", 급여 = " + salary ;
	}
	
}

