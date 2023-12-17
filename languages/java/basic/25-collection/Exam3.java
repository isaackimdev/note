import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

// HashSet 사용하기 저장/읽어오기/삭제
public class Exam3 {
	public static void main(String[] args) {
		// collection 계열 및 Database 공부할 때 아래 기준은 필수
		// CRUD (Create, read, update, delete)
		// 중복허용안됨, 순서없음
		
		Set<String> set = new HashSet<String>();
		set.add("호랑이");
		set.add("사자");
		set.add("코끼리");
		set.add("기린");
		set.add("코뿔소");
		System.out.println("데이터의 개수 : " + set.size());
		
		Iterator<String> it = set.iterator();
		while(it.hasNext()) {		// hasNext() 데이터 값이 있는지 확인 >> while 문과 함께 사용
			System.out.println(it.next());	// hasNext() 값으로 데이터가 있는지 확인 후, Iterator it = set.iterator(); 의, it.next() 으로 모든 값 출력하기
		}
		
	}

}
