import java.util.Scanner;

public class Practice3 {
		

	static int square(int s1){
		return s1*s1;
	}
	
	static double square(double s2){
		return s2*s2;
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int s1;
		double s2;
		
		System.out.print("정수 입력 : ");
		s1 = sc.nextInt();
		
		System.out.print("실수 입력 : ");
		s2= sc.nextDouble();
		
		System.out.println("정수 제곱 : " + square(s1));
		System.out.println("실수 제곱 : " + square(s2));
		
	}

}
