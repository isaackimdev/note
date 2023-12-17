import java.util.HashMap;
import java.util.Map;

public class Exam1 {
	public static void main(String[] args) {
		// Map : 순서가 없고, 키값의 중복이 허용안됨
		// 제너릭 --> <값의 이름, 값의 종류> => <이름, 데이터>
		// => 반드시 클래스 이름을 주어야 한다.
		Map<String, Integer> map = new HashMap<String, Integer>();	// Map 은 interface
		// 데이터 추가는 put 메소드 사용
		// --> 키값의 중복을 허용하지 않는다.
		// put(키값, 데이터);
		map.put("aaa",111);
		map.put("bbb", 222);
		map.put("aaa",444);
		map.put("ccc", 333);
		map.put("ccc", null);	// 객체를 넣는 것이므로 null 사용 가능
		// 저장된 갯수 얻기
		System.out.println("HashMap size : " +map.size());
		// 데이터 꺼내기
		System.out.println(map.get("aaa"));
		System.out.println(map.get("bbb"));
		System.out.println(map.get("ccc"));
		
		
		

	}
}
