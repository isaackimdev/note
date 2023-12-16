
public class Exam2 {
	public static void main(String[] args) {
		
		System.out.println("--- 2000년 ---");
		BankStatic.setRate(2.5); // 클래스와 상관없이 독립적으로 바로 사용가능
		BankStatic hong = new BankStatic("홍길동",10000);
		hong.print_account();
		
		System.out.println("--- 2008년 ---");
		BankStatic.setRate(4.5); // 클래스와 상관없이 독립적으로 바로 사용가능
		BankStatic kim = new BankStatic("김철수",20000);
		hong.print_account();
		kim.print_account();
		
		System.out.println("--- 2018년 ---");
		BankStatic.setRate(5.5); // 클래스와 상관없이 독립적으로 바로 사용가능
		BankStatic lee = new BankStatic("이영희",20000);
		hong.print_account();
		kim.print_account();
		lee.print_account();
		
	}	
}
