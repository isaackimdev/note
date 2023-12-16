// 함수의 오버로딩
public class Practice4 {

	public static void main(String[] args) {
		Test4 t4 = new Test4();
		System.out.println("원의 넓이 : " + t4.area(3) );
		System.out.println("사각형의 넓이 : " + t4.area(4,5));
		System.out.println("사다리꼴의 넓이 : " + t4.area(3,4,7));
	}

}
