
public class Bank {
	
	private String name;	// 이름
	private double balance;	// 잔고
	private double rate;	// 이율

	public Bank () {
		name = null;
		balance = 0;
		rate = 0 ;
	}	
	
	public Bank(String name, double balance, double rate) {		
		this.name = name;
		this.balance = balance;
		this.rate = rate;
	}
	
	public void print_account() {
		System.out.println(name + "\t" + balance + "원\t"
				+ rate + "%");
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
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	
}
