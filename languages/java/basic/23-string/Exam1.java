public class Exam1 {
	public static void main(String[] args) {
		// String 객체의 생성 방법
		String str1 = "자바 Programing";	// 약식표현
		String str2 = new String("Java");
		System.out.println("str1 : " + str1);
		System.out.println("str2 : " + str2);
		System.out.println("----------");
		// 1) 문자열의 길이를 조회
		int str1_len = str1.length();
		int str2_len = str2.length();
		System.out.println("str1_len : " + str1_len);
		System.out.println("str2_len : " + str2_len);
		System.out.println("----------");
		// 2) 특정 문자열이 첨으로 나타나는 위치를 조회
		int str1_pos = str1.indexOf(" ");
		int str2_pos = str2.indexOf("a");
		System.out.println("str1_pos : " + str1_pos);	// 0 부터 count > 왼쪽에서 오른쪽으로 확인
		System.out.println("str2_pos : " + str2_pos);	// 0 부터 count > 왼쪽에서 오른쪽으로 확인
		System.out.println("----------");
		// 3) 특정 문장열이 나타나는 마지막 위치를 조회
		int str1_last_pos = str1.lastIndexOf(" ");	// 중간 단어 대문자
		int str2_last_pos = str2.lastIndexOf("a");	// 중간 단어 대문자
		System.out.println("str1_last_pos : " + str1_last_pos);	// 0 부터 count > 오른쪽에서 왼쪽으로 확인
		System.out.println("str2_last_pos : " + str2_last_pos);	// 0 부터 count > 오른쪽에서 왼쪽으로 확인
		System.out.println("----------");
		// 4) A를 B로 변경하기
		String new_str1 = str1.replace(" ", "_");
		String new_str2 = str2.replace("a", "A");
		System.out.println("str1 : " + str1);
		System.out.println("str2 : " + str2);
		System.out.println("new_str1 : " + new_str1);
		System.out.println("new_str2 : " + new_str2);
		System.out.println("----------");
		// 5) 대소문자 변경
		String upper = new_str2.toUpperCase();
		String lower = new_str2.toLowerCase();
		System.out.println("upper : " + upper);
		System.out.println("lower : " + lower);
		System.out.println("----------");
		// 6) 문자열의 앞뒤 공백 제거
		String input = "      enjoy java programming     " ;
		String output = input.trim() ;		// trim() 메소드는 앞뒤의 공백을 잘라줌
		System.out.println("input : " + input);
		System.out.println("output : " + output);
		// 중간 공백까지 포함한 모든 공백 제거
		String output2 = input.replace(" ", "");
		System.out.println("output2 : " + output2);
		System.out.println("----------");
		// 7) 문자열 비교하기
		boolean isSame = str1.equals(str2);
		if(isSame) {
			System.out.println("같다.");
		}else {
			System.out.println("다르다.");
		}
		System.out.println("----------");
		// 8) 문자열을 자르기
		// - 첫 번째 파라미터 : 시작 위치
		// - 두 번째 파라미터 : 끝 위치 뒤
		String sub_str1 = str1.substring(3,4);
		System.out.println("str1 : " + str1);
		System.out.println("sub_str1 : " + sub_str1);
		// 두 번째 피라미터가 없는 경우 끝까지 자른다.
		String sub_str2 = str1.substring(3);
		System.out.println("sub_str2 : " + sub_str2);
		System.out.println("----------");

		// 오른쪽 끝 글자만 자르기
		// result : 001 -> 1
		String subStr = "001";
		System.out.println("'"+ subStr + "' last char : "+ subStr.charAt(subStr.length()-1));
		// 마지막 세글자 자르기
		String subStr2 = "1104567890";
		System.out.println("subStr2 last 3 char : " + subStr2.substring(7, 10));

		// 9) 형식에 따른 문자열 출력을 위한 static 메소드 사용
		/**
		 * 		%d : 정수
		 * 		%s : 문자열
		 * 		%f : float형 소수
		 * 		%3d : 정수를 3자리로 맞춰서 출력
		 */
		int yy = 2018;
		int mm = 5;
		int dd = 3;
		String gender = "남자";
		String result = String.format("%d년 %02d월 %02d일 %s",		// 빈공간을 0 으로 채워라  => 05 , 03
							yy,mm,dd,gender);						//String 클래스, 함수는 static 으로 되어 잇음
		System.out.println(result);
		System.out.println("----------");
		// 10) 주어진 글자를 기준으로 잘라내어서 배열로 변환
		String src = "C++/Java/C#/Javascript/HTML";
		String[] data = src.split("/");
		for(int i = 0 ; i<data.length; i++) {
			System.out.println(data[i]);
		}
		
	}

}
















