import java.util.Scanner;

public class Practice1 {
	static int input ( ) {
		Scanner sc = new Scanner(System.in);
		System.out.print("1~100사이의 배수를 구할 숫자 입력 : ");
		int num = sc.nextInt();
		return num;
	}
	static int double_cnt (int num) {
		int count = 0;
		for (int x=1; x<=100; x++) {
			if(x%num == 0) {
				System.out.print(x + " ");
				 count++;
			}
		}
		return count;
	}
	
	static void output (int num, int count){
		System.out.println();
		System.out.println("1~100 사이의 " + num + " 의 배수 개수 =" + count);
	}
	public static void main(String[] args) {

		int num=0, count=0;
		
		num = input ( ); 
		
		count = double_cnt(num);
		
		output( num , count );

		
	}

}
