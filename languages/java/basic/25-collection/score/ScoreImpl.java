package score;

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
	// 선언
	private List<ScoreVO> list = new ArrayList<ScoreVO>();
	Scanner sc = new Scanner(System.in);
	// 입력
	@Override
	public void input() {
		ScoreVO vo = new ScoreVO();
		System.out.print("학번 : ");
		vo.setHak(sc.next());
		System.out.print("이름 : ");
		vo.setName(sc.next());
		System.out.print("국어 : ");
		vo.setKor(sc.nextInt());
		System.out.print("영어 : ");
		vo.setEng(sc.nextInt());
		System.out.print("수학 : ");
		vo.setMat(sc.nextInt());
		int tot = vo.getKor() + vo.getEng() + vo.getMat();
		vo.setTot(tot);
		vo.setAvg((double)tot/3);
		
		list.add(vo);
	}
	
	// 출력
	@Override
	public void printTitle() {
		String str = String.format("%3s %4s %2s %2s %2s %2s %2s",
				"학번","이름","국어","영어","수학","총점","평균");
		System.out.println(str);
	}
	
	@Override
	public void print() {
		printTitle();
		Iterator<ScoreVO> it = list.iterator();
		while(it.hasNext()) {
			ScoreVO vo = it.next();
			System.out.println(vo.toString());
		}
		System.out.println();
	}
	// 연산
	@Override
	public void searchHak() {
		System.out.print("검색할 학번? ");
		String hak = sc.next();
		
		Iterator<ScoreVO> it = list.iterator();
		while(it.hasNext()) {
			ScoreVO vo = it.next();
			if(vo.getHak().equals(hak)) {	// 정수일 경우 == 으로 하여도 되는데, 문자열이기 때문에 .equals() 함수를 씀.
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
		
		Iterator<ScoreVO> it = list.iterator();
		while(it.hasNext()) {
			ScoreVO vo = it.next();
			if(vo.getName().equals(name)) {
				printTitle();
				System.out.println(vo.toString());
				System.out.println();
			}
		}
	}
	// 총점 기준 내림차순 정렬
	@Override
	public void descSortTot() {
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
		print();
	}
	// 학번 기준 오름차순 정렬
	@Override
	public void ascSortHak() {
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
		print();
	}
	
	/** 새로 만드는 함수 */
	@Override
	public void write() {
		
	}
	@Override
	public void read() {
		
	}
}



