
public class BankStatic {
	private String name;
	private double balance;
	private static double rate;	// 모든 객체들이 공통으로 사용
								// 변수나 함수들이 
	
	// 생성자
	public BankStatic() {
		name = null;
		balance = 0 ;
	}

	public BankStatic(String name, double balance) {
		this.name = name ;
		this.balance = balance;
	}
	
	public void print_account() {
		System.out.println(name + "\t" + balance+
				"원\t" + rate + "%");	
	}
	
	public double getRate() {
		return BankStatic.rate;
	}
	// static 이 붙은 명령어는 모든 class 에서 사용 가능
	// 만들자 마자 메모리에 저장되어 있음.
	// 다른 전체 class 에서 공유하여 사용할 수 있음.
	public static void setRate(double rate) {
		BankStatic.rate = rate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
}
