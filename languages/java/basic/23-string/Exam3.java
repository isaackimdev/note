// 주민번호에서 생년월일 성별 추출하기
// - ex) 8005011234567 -- > 1980년 05월 01일 남자

public class Exam3 {
	public static void main(String[] args) {

		String idNum2 = "9006071234567";	// 주민등록번호
		String y, m, d ;					// 년원일
		String gender = "";					// 성별
		String gener = "";					// 세기
		// 주민번호를 년, 월, 일 단위로 각 두 글자씩 자르기
		y = idNum2.substring(0,2);	// 년
		m = idNum2.substring(2,4);	// 월
		d = idNum2.substring(4,6);	// 일
		// 성별 추출
		gender = idNum2.substring(6,7);
		// 성별 판별
		switch(gender) {
		case "1" : gender = "남자";
					gener = "19";
			break;
		case "2" : gender = "여자";
					gener = "19";
			break;
		case "3" : gender = "남자";
					gener = "20";
			break;
		case "4" : gender = "여자";
					gener = "20";
			break;
		}

		// output
		System.out.println( gener + y +"년 "+ m + "월 "+d+ "일 "+gender);
	}
	
}
