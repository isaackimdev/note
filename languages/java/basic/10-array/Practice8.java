// 2차원 배열
public class Practice8 {
	static void calculate(int[][]a){
		for(int x=0; x<3; x++) {		// 행
			for(int y=0; y<3; y++) {	// 열
				a[x][3] += a[x][y];  
				a[3][x] += a[y][x];
				a[3][3] += a[x][y];
			}
		}
	}
	static void output(int[][]a) {
		for(int x=0; x<4; x++) {		// 행
			for(int y=0; y<4; y++) {	// 열
				System.out.printf("%3d", a[x][y]);
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		// 선언
		int[][] a = {{1,2,3,0},
					 {4,5,6,0},
					 {7,8,9,0},
					 {0,0,0,0}};
		// 입력
		// 연산
	
			calculate(a);
		
		// 출력
			
			output(a);

		
	} // main
} // class
