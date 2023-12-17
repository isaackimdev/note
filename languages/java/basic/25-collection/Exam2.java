import java.util.ArrayList;
import java.util.List;

public class Exam2 {

	public static void main(String[] args) {
		// List : 순서가 있고, 중복허용함
		// 배열과 비슷한 기능 
							//List.awt : 그래픽과 관련된 클래스
		List<Integer> list = new ArrayList<Integer>();
		// 데이터 추가
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		list.add(50);
		list.add(60);
		// 자동으로 배열이 매겨짐
		//0[10]-->1[20]-->2[30]-->3[40]-->4[50]-->5[60]
		
		// 추가된 데이터의 수량
		System.out.println("데이터의 갯수 : " + list.size());
		// 5번째 요소의 값 얻기
//		System.out.println(list.get(4));
		int value = list.get(4);
		System.out.println("5번째 요소의 값 : " + value);
		// 5번째 요소 삭제
		list.remove(4);
		// 삭제된 후 데이터의 수량
		System.out.println("데이터의 갯수 : " + list.size());
		System.out.println("5번째 값 : " + list.get(4));
		value = list.get(4);
		System.out.println("5번째 요소의 값 : " + value);
		// 3번째 자리에 데이터 추가
		list.add(2, 123);
		System.out.println("데이터의 갯수 : " + list.size());
		// 5번째 요소의 값 얻기
//		System.out.println(list.get(4));
		value = list.get(4);
		System.out.println("5번째 요소의 값 : " + value);
		// 값 수정
		list.set(4, 500);	// 특정 위치의 값 변경
		System.out.println("데이터의 갯수 : " + list.size());
		value = list.get(4);
		System.out.println("5번째 요소의 값 : " + value);
		
		// List의 전체삭제
		list.clear();
		System.out.println("데이터의 갯수 : " + list.size());
		
		
		// 중간에 추가 add,
		// 수정은 set
		// 부분 한개 삭제 remove
		// 요소값 얻기 get
		// 전체 삭제 clear
			
	}

}
