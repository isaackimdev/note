package sample7;

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
	@Override
	public String toString() {
		return "이름 = " + name + ", 급여 = " + salary ;
	}
	
}
