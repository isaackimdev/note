
public class Exam5_1 {

	public static void main(String[] args) {
		String[] src = {"1", "가" , "3", "4"};
		// src의 내용들을 숫자로 변환해서 저장할 배열
		int[] arr = new int[2];		
		
		try {
			for(int i=0 ; i < src.length; i++) {
				arr[i] = Integer.parseInt(src[i]);
				System.out.println(arr[i]);
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
			System.out.println("데이터의 갯수가 너무 많습니다.");
			
		} catch (Exception e) {
			// 예외 종류를 의미하는 모든 클래스는 java.lang.Exception 클래스를 상속받으므로,
			// 이 블록은 모든 종류의 예외에 대처할 수 있다.
			System.out.println(" 에러가 발생했습니다.");
		} finally {
			
			System.out.println(" 데이터 변환 종료 ");
		}
		
		System.out.println(" 프로그램을 종료합니다.");
		}

}
