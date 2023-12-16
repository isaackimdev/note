// 함수의 오버로딩
public class Test4 {
	final double PI = 3.14159; // 원주율
	/**
	 * 원의 넓이	
	 * @param a : 반지름
	 * @return 원의넓이
	 */
	double area(int a){		// 원의 넓이
		return a*a*PI;
	}
	/**
	 * 사각형의 넓이
	 * @param a : 밑변
	 * @param b : 높이
	 * @return 사각형의 넓이
	 */
	double area(int a, int b){	// 사각형의 넓이
		return a*b;
	}
	/**
	 * 사다리꼴의 넓이
	 * @param a : 밑변
	 * @param b : 윗변
	 * @param c : 높이
	 * @return 사다리꼴의 넓이
	 */
	double area(int a, int b, int c){	// 사다리꼴의 넓이
		return ((double)a+b)*c/2;
	}
	
}
