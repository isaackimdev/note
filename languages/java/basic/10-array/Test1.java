
public class Test1 {
	// 난수 발생 : 임의의 숫자 만들기 => Math 클래스
	/*
	 * Math.random() 메서드는 0~1 범위를 갖는 double형의 값을 리턴하기 떄문에,
	 * 원하는 범위의 값을 생성하기 위해서는 일련의 공식 적용이 필요하다.
	 */
	public static void main(String[] args) {
		//System.out.println(Math.random());
		int min = 65;
		int max = 90;
		double ran =Math.random();
		int r = (int)(ran * (max-min+1)+min);
		System.out.println("65=" + (char)65);
		System.out.println("90=" + (char)90);
		System.out.println(ran);
		System.out.println(r + " = " + (char)r );
	}

}
