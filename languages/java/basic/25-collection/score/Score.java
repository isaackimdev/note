package score;

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

	public void write();	// 파일저장 함수 추가
	public void read();		// 파일읽기 함수 추가
	
}
