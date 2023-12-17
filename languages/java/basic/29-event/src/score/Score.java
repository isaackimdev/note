package score;

import java.util.List;

// 인터페이스 용도 (추상클래스)
// 1. 상속받는 자식클래스에게 강제적으로 함수를 만들게 함.
// 2. 목차역할
public interface Score {
	public void input(ScoreVO vo);		// 입력
	public String print();		// 출력
	public String printTitle();	// 출력 제목
	public String searchHak(String hak);	// 검색 : 학번
	public String searchName(String name);	// 검색 : 이름
	public String descSortTot();	// 정렬 : 총점 기준, 내림차순 (큰값 부터 작은 값)
	public String ascSortHak();	// 정렬 : 학번 기준, 오름차순
	
	public String saveFile();		// 파일 저장
	public String readFile();		// 파일 읽기
	
}
