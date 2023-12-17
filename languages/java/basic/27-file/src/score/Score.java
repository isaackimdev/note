package score;

import java.util.List;

// 인터페이스 용도 (추상클래스)
// 1. 상속받는 자식클래스에게 강제적으로 함수를 만들게 함.
// 2. 목차역할
public interface Score {
	public void input();		// 입력
	public void print();		// 출력
	public void printTitle();	// 출력 제목
	public void searchHak();	// 검색 : 학번
	public void searchName();	// 검색 : 이름
	public void descSortTot();	// 정렬 : 총점 기준, 내림차순 (큰값 부터 작은 값)
	public void ascSortHak();	// 정렬 : 학번 기준, 오름차순
	
	public void saveFile();		// 파일 저장
	public void readFile();		// 파일 읽기
	
}
