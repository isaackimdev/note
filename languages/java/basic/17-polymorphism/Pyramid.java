
public class Pyramid extends DrawData {// 출력문자로 도형그리기 
	@Override
	void draw(){
		for(int x=1; x<=5; x++) {				// 층수
			for(int y=1; y<=5-x; y++) { // 공백문자 출력
				System.out.print(" ");
			}
			for(int y=1; y<=(2*x-1); y++) {	// 문자 출력
				System.out.print(st);
			}
			System.out.println();
		}
	}	
}
