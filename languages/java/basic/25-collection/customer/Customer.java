package customer;

public interface Customer {
	public void input();			// 입력
	public void printTitle();		// 제목 출력
	public void print();			// 전체 출력
	public void searchNo();			// 검색 : 고객번호
	public void searchName();		// 검색 : 아름
	public void searchPhone();		// 검색 : 전화번호
	public void descSortName();		// 정열 : 이름, 내림차순
	public void ascSortNo();		// 정렬 : 고객번호, 오름차순
}
