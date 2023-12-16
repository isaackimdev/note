import java.util.Scanner;

public class Practice3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Test3[] op = new Test3[2];
		
		for(int x=0; x<op.length; x++) {
			op[x] = new Test3();
			op[x].input();
			op[x].setProcess();	// 총액 저장
			int cnt = op[x].getQty() + Sales.getCnt();
			Sales.setCnt(cnt);	// 총판매건수 저장
		}
		
		System.out.print("할인율 : ");
		Sales.setDiscount(sc.nextDouble());
		
		System.out.println("[[판매가]]");
		for(int x=0; x<op.length; x++) {
			op[x].getDisplay();
		}
		System.out.println("판매건수 : " + Sales.getCnt());
	}
}






