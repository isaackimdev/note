package customer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import score.ScoreVO;

public class CustomerImpl implements Customer{
	// 선언
	Scanner sc = new Scanner(System.in);
	private List<CustomerVO> list = new ArrayList<CustomerVO>(); // 담아놓은 리스트 콜렉션 make
	
	// 입력
	@Override
	public void input() {
		CustomerVO vo = new CustomerVO();	// 자바빈즈 클래스 생성
		System.out.print("고객번호 : ");
		vo.setNo(sc.next());
		System.out.print("이    름 : ");
		vo.setName(sc.next());
		System.out.print("전화번호 : ");
		vo.setPhone(sc.next());						// 바로 저장
		
		list.add(vo);
		
	}
	// 출력
	@Override
	public void printTitle() {
		String str = String.format("%6s %7s %13s",
				"고객번호", " 이름", "전화번호");
		System.out.println(str);
	}

	@Override
	public void print() {
		printTitle();
		Iterator<CustomerVO> it = list.iterator();
		while(it.hasNext()) {
			System.out.println(it.next().toString());
		}
	}
	// 연산
	@Override
	public void searchNo() {
		System.out.print("검색할 고객번호? ");
		String no = sc.next();
		
		Iterator<CustomerVO> it = list.iterator();
		while(it.hasNext()) {
			CustomerVO vo = it.next();
			if(vo.getNo().equals(no)) {	// 정수일 경우 == 으로 하여도 되는데, 문자열이기 때문에 .equals() 함수를 씀.
				printTitle();
				System.out.println(vo.toString());
				System.out.println();
			}
		}
	}

	@Override
	public void searchName() {
		System.out.print("검색할 이름? ");
		String name = sc.next();
		
		Iterator<CustomerVO> it = list.iterator();
		while(it.hasNext()) {
			CustomerVO vo = it.next();
			if(vo.getName().equals(name)) {	// 정수일 경우 == 으로 하여도 되는데, 문자열이기 때문에 .equals() 함수를 씀.
				printTitle();
				System.out.println(vo.toString());
				System.out.println();
			}
		}
	}

	@Override
	public void searchPhone() {
		System.out.print("검색할 고객번호? ");
		String phone = sc.next();
		
		Iterator<CustomerVO> it = list.iterator();
		while(it.hasNext()) {
			CustomerVO vo = it.next();
			if(vo.getPhone().equals(phone)) {	// 정수일 경우 == 으로 하여도 되는데, 문자열이기 때문에 .equals() 함수를 씀.
				printTitle();
				System.out.println(vo.toString());
				System.out.println();
			}
		}
	}

	@Override
	public void descSortName() {
		Comparator<CustomerVO> comp = new Comparator<CustomerVO>() {
			
			@Override
			public int compare(CustomerVO vo2, CustomerVO vo1) {
				// String 클래스가 Comparable<String>를 상속박았기 때문에
				// compareTo()가 구현되어 있다.
				// 문자열일 경우 이 방법으로 정렬 제시
				return vo2.getName().compareTo(vo1.getName());	// 내림차순임 현재
			}
		};
		
		Collections.sort(list, comp);
		print();
	}

	@Override
	public void ascSortNo() {
		Comparator<CustomerVO> comp = new Comparator<CustomerVO>() {
			
			@Override
			public int compare(CustomerVO vo2, CustomerVO vo1) {
				// String 클래스가 Comparable<String>를 상속박았기 때문에
				// compareTo()가 구현되어 있다.
				// 문자열일 경우 이 방법으로 정렬 제시
				return vo2.getNo().compareTo(vo1.getNo());	// 오름차순으로 변경
			}
		};
		
		Collections.sort(list, comp);
		print();
	}

}
