package score;
// cli 에서 윈도우 프로그램으로 바꿔서 사용
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

// Controller : 기능 구현 클래스
public class ScoreImpl implements Score {	// implements 구현하다
	// 선언 : 모든 데이터는 list 에 저장됨.
	private List<ScoreVO> list = new ArrayList<ScoreVO>();
	Scanner sc = new Scanner(System.in);
	// 입력
	@Override
	public void input(ScoreVO vo) {
		list.add(vo);
	}
	
	// 출력
	@Override
	public String printTitle() {
		String str = String.format("%3s %4s %2s %2s %2s %2s %2s",
				"학번","이름","국어","영어","수학","총점","평균");
		return str;
		//System.out.println(str);
	}
	
	@Override
	public String print() {
		String result = printTitle() + " \n";
		Iterator<ScoreVO> it = list.iterator();
		while(it.hasNext()) {
			ScoreVO vo = it.next();
			result += vo.toString() + "\n";
			//System.out.println(vo.toString());
		}
		return result;
		//System.out.println();
	}
	// 연산
	@Override
	public String searchHak(String hak) {
		String result = "";
		//System.out.print("검색할 학번? ");
		//String hak = sc.next();
		
		Iterator<ScoreVO> it = list.iterator();
		while(it.hasNext()) {
			ScoreVO vo = it.next();
			if(vo.getHak().equals(hak)) {	// 정수일 경우 == 으로 하여도 되는데, 문자열이기 때문에 .equals() 함수를 씀.
				result = printTitle() + "\n";
				result += vo.toString() + "\n";
				return result;
				
				//System.out.println(vo.toString());
			
			}
		}
		return "학번이 없습니다.";
	}
	
	@Override
	public String searchName(String name) {
		String result = "";
		
		Iterator<ScoreVO> it = list.iterator();
		while(it.hasNext()) {
			ScoreVO vo = it.next();
			if(vo.getName().equals(name)) {
				result = printTitle() + "\n";
				result += vo.toString();
//				System.out.println(vo.toString());		
				return result;
			}
		}
		return "이름이 없습니다.";
	}
	// 총점 기준 내림차순 정렬
	@Override
	public String descSortTot() {
		// 정렬기준
		Comparator<ScoreVO> comp = new Comparator<ScoreVO>() {
			
			@Override
			public int compare(ScoreVO vo1, ScoreVO vo2) {
				// 숫자 기준으로 정렬할 경우 이 방법으로 정렬 제시
				return vo1.getTot() < vo2.getTot() ? 1 : -1;
				// [ < ] :  내림차순 [ > ] :  오름차순 
			}
			
		};
		// 정렬
		Collections.sort(list, comp);
		return print();
	}
	// 학번 기준 오름차순 정렬
	@Override
	public String ascSortHak() {
		Comparator<ScoreVO> comp = new Comparator<ScoreVO>() {
			
			@Override
			public int compare(ScoreVO vo1, ScoreVO vo2) {
				// String 클래스가 Comparable<String>를 상속박았기 때문에
				// compareTo()가 구현되어 있다.
				// 문자열일 경우 이 방법으로 정렬 제시
				return vo1.getHak().compareTo(vo2.getHak());
			}
		};
		
		Collections.sort(list, comp);
		return print();
	}

	@Override
	public String saveFile() {
		ObjectInOut2 objectInOut2 = new ObjectInOut2();
		boolean result = objectInOut2.write("score.txt", list);
		if(result) {
			return "저장 성공";
		} else {
			return "저장 실패";
			//syso 에서 return 스트링
		}
	}

	@Override
	public String readFile() {
		ObjectInOut2 objectInOut2 = new ObjectInOut2();
		list.clear(); 		// 기존 데이터 지우기 
		list = objectInOut2.read("score.txt");
		if(list != null) {
			return "읽기 성공";
		} else {
			return "읽기 실패";
		}
	}
}
