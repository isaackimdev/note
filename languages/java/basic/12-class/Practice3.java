
public class Practice3 {

	public static void main(String[] args) {
		
		Triangle3 t3 = new Triangle3();
		
//		t3.getArea();		// 삼각형의 넓이 리턴(완료)
//		t3.getHypotenuse();	// 빗변의 길이를 리턴(완료)
//		t3.getPerimeter();	// 둘레길이를 리턴 (완료)
		// 각각의 메서드를 호출하여 출력하시오
		t3.output();
		
	}

}

// 2.[공 식]
// 삼각형의 넓이 = (밑변*높이)/2
// 빗변 길이 = Math.sqrt(밑변*밑변+높이*높이)
// 둘레길이 = 밑변 + 높이 + 빗변길이