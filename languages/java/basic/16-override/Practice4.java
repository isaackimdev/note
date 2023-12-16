
public class Practice4 {
	public static void main(String[] args) {
		
		CircleArea ob1 = new CircleArea(10);
		CircleRound ob2 = new CircleRound(10);
		
		ob1.compute();
		ob1.output();
		ob2.compute();
		ob2.output();		
	}
}
// 실행결과
//원의 널비 : 314.1592
//원의 둘레 : 62.83184