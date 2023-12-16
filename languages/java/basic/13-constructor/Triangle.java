class Triangle {
	int base, height;	 // 밑변,높이
	
	Triangle() {	// 멤버변수 초기화
		this.base = 0;
		this.height = 0;
	}
	Triangle(int base, int height) {	// t2
		this.base = base;
		this.height = height;
	}
	void setTriangle(int base, int height) {
		
		this.base = base;
		this.height = height;
		// 밑변 높이 대입
	}
	double getArea() {
		
		return base * height/2.0;
		// 삼각형의 널이 리턴
	}
	
}

// 생성자 함수를 만들어 놓지 않으면 default 값이 자동 출력
// 생성자 함수가 있는 경우, 맞는 매개변수의 값에 따라 출력