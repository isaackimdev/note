
public class Exam4 {
	public static void main(String[] args) {
		int a = 1;
		System.out.println("a = " + a);
		// 변수값을 1씩 증가
		a = a + 1;
		System.out.println("a = " + a);
		a += 1;
		System.out.println("a = " + a);
		// 증감연산자 ++ : 이 연산자는 반드시 변수와 함께 사용해야함, 변수값 1증가
		a++;
		System.out.println("a = " + a);
		++a;
		System.out.println("a = " + a);
		
		// 변수값을 1씩 감소
	
		
		System.out.println();
		a = a - 1;
		System.out.println("a = " + a);
		a -= 1;
		System.out.println("a = " + a);
		// 증감연산자 -- : 이 연산자는 반드시 변수와 함께 사용해야함, 변수값 1감소
		a--;
		System.out.println("a = " + a);
		--a;
		System.out.println("a = " + a);
		
		// 증감 연산자를 사용할 때, 주의사항 [증감연사자는 우선순위가 2개]
		// a++, a-- : 제일 꼴찌 우선순위
		// ++a, --a : 2순위
		int x = 100;
		int y = 1;
		int z = x + y++;
		System.out.println("z = " + z);
		System.out.println("y = " + y);
			
		x = 100;
		y = 1;
		z = x + ++y;
		System.out.println("z = " + z);
		System.out.println("y = " + y);
		
	}
}
