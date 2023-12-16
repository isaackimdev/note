	
class Triangle3{
		// 선언
		double base = 5.0;
		double height = 3.5;
		// 입력
		// 연산
		double getArea(){	// 삼각형의 넓이 리턴(완료)
			return base*height / 2; 
		} 
		double getHypotenuse(){	// 빗변의 길이를 리턴(완료)
			return Math.sqrt(base*base+height*height);
		}	// Math.sqrt 는 root (근의 공식) C=루트(a제곱+b제곱)
		double getPerimeter(){	// 둘레길이를 리턴
			return base + height + getHypotenuse();
		}
		void output(){			// 결과출력
		System.out.println("삼각형의넓이: " + getArea());
		System.out.printf("빗변길이 : %.2f\n" , getHypotenuse());
		System.out.printf("둘레길이 : %.2f\n" , getPerimeter());
		}
		
		
	}
	


