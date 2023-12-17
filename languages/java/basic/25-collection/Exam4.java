import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import study.java.model.People;

public class Exam4 {
	/** List를 사용하는 가장 일반적인 방법은
	 *  사용자 정의 클래스에 대한 객체를 포함하도록 지정하는 것이다.
	 */
	public static void main(String[] args) {
		// 객체를 담기 위한 ArrayList
		List<People> list = new ArrayList<People>();
		// 10명의 데이터를 임의로 추가함
		for(int i = 0 ; i<10; i++) {
			People people = new People("jAVA회원"+ i, "010-1234-567"+ i);
			list.add(people);
		}
		System.out.println("데이터의 개수 : " + list.size());
		// 출력하기 1. for 사용
		for(int i=0; i<list.size() ; i++ ) {
			People people = list.get(i);
			System.out.println(people.toString());	// people 만 써도 됨.
		}
		System.out.println("----------------------");
		 //2. Iterator 사용
		Iterator<People> it = list.iterator();
		while(it.hasNext()) {
			People people = it.next();
			System.out.println(people.toString());
		}
	
	}
}
