// 다형성을 이용해서 도형의 높이와 출력문자를 입력받아 도형을 그리는 프로그램을 작성해보자.

public class Practice1 {
	public static void main(String[] args) {
		
		// 부모 클래스 기준 사용법
		DrawData d1 = 
				new IsoTriangle();
		d1.setHeight(7);
		d1.setOutchar("A");
		d1.draw();
		// 자식 클래스 기준 사용법
		IsoTriangle iso = new IsoTriangle();
		iso.setHeight(10);
		iso.setOutchar("X");
		iso.draw();
	}
}
