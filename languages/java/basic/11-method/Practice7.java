/*
 *  - 년, 월 ,일을 전달받아 출력하는 함수
 *  - 년, 월 ,일, 날짜 구분기호를 전달받아 출력하는 함수
 *  - 문자열 형태의 날짜를 전달받아 출력하는 함수
 */

public class Practice7 {
	
	static void outData(int y, int m, int d){
		System.out.println(y+"/"+m+"/"+d);
	}
	
	static void outData(int y, int m , int d, char ch){
		System.out.println(""+ y + ch + m + ch + d);
		System.out.println(y + String.valueOf(ch) +
						m + String.valueOf(ch) + d);
	}			//*String.valueOf(ch) 문자열로 바꿔라!*
	
	static void outData(String str){
		System.out.println(str);	
	}
	
	public static void main(String[] args) {
		
		outData(2004,3,5);
		
		outData(2007,8,5,'#');
		
		outData("2006/9/2");
	
	}
}
