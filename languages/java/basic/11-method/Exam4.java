
public class Exam4 {

	// 결과값 또한 정수.. 정수를 돌려준다.
	static int sum (int start, int end){				// 매개 변수 전달받은 정수
		int tot = 0;
		for (int a=start; a<=end; a++) {
			tot += a;
		}
		return tot;
	} 
	
	public static void main(String[] args) {
		
		System.out.println(sum(1,10));
		System.out.println(sum(1,3) + sum(5,7));
	}

}
