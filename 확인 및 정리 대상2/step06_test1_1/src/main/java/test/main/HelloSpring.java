package test.main;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Component;

import test.bean.ScoreVO;
import test.service.ScoreServiceImpl;

@Component	// 기능 처리 O , 데이터 저장 X
public class HelloSpring {
	@Autowired	// bean 객체가 있으면 바로 초기화 시켜줌, 빈 객체를 자동으로 주입 시켜줌
	ScoreServiceImpl scoreService;
	Scanner scanner = new Scanner(System.in);
	
	
	public void menu() {
		int num = 0;
		
		while(true) {
			do {
				System.out.println();
				System.out.println("--------------");
				System.out.println("	1. 입력");
				System.out.println("	2. 출력");
				System.out.println("	3. 수정");
				System.out.println("	4. 삭제");
				System.out.println("	5. 종료");
				System.out.println("--------------");
				System.out.print("번호 : ");
				num = scanner.nextInt();
			} while(num < 1 || num > 5);
			if(num == 5) {
				System.out.println("종료합니다.");
				return;	// exit,  [ break, return 권장 ]
			}
			
			switch (num) {
			case 1 :	// 입력
				input();
				break;
			case 2 :	// 출력
				output();
				break;
			case 3 :	// 수정
				modify();
				break;
			case 4 :	// 삭제
				delete();
				break;
			}
		}
	}
	private void input() {
		ScoreVO vo = new ScoreVO();
		int result = 0;
		int tot = 0;
		System.out.println();
		System.out.print("학번 : ");
		vo.setStudNo(scanner.next());
		System.out.print("이름 : ");
		vo.setName(scanner.next());
		System.out.print("국어 : ");
		vo.setKor(scanner.nextInt());
		System.out.print("영어 : ");
		vo.setEng(scanner.nextInt());
		System.out.print("수학 : ");
		vo.setMat(scanner.nextInt());
		tot = vo.getKor() + vo.getEng() + vo.getMat();
		vo.setTot(tot);
		vo.setAvg((double)tot/3);
		
		result = scoreService.insertScore(vo);
		
		if(result > 0) {
			System.out.println("저장 성공");
		} else {
			System.out.println("저장 실패");
		}
		
	}
	private void output() {
		List<ScoreVO> list = scoreService.getScoreList(null);
		for(ScoreVO vo : list) {	// 모든 데이터를 다 출력할때, [사용법 : 일반 포문, 이터레이터, 확장 포문]
			System.out.println(vo.toString());
		}
	}
	private void modify() {	// 문제발생
		ScoreVO vo = new ScoreVO();
		int result = 0;
		int tot = 0;
		System.out.println();
		System.out.print("수정할 학번 : ");
		vo.setStudNo(scanner.next());
		System.out.print("국어 : ");
		vo.setKor(scanner.nextInt());
		System.out.print("영어 : ");
		vo.setEng(scanner.nextInt());
		System.out.print("수학 : ");
		vo.setMat(scanner.nextInt());
		tot = vo.getKor() + vo.getEng() + vo.getMat();
		vo.setTot(tot);
		vo.setAvg((double)tot/3);
		
		result = scoreService.updateScore(vo);
		
		if(result > 0) {
			System.out.println("수정 성공");
		} else {
			System.out.println("수정 실패");
		}
		
	}
	private void delete() {
		ScoreVO vo = new ScoreVO();
		int result = 0;
		System.out.println();
		System.out.print("삭제할 학번 : ");
		vo.setStudNo(scanner.next());
		
		result = scoreService.deleteScore(vo);
		
		if(result > 0) {
			System.out.println("삭제 성공");
		} else {
			System.out.println("삭제 실패");
		}
		
	}

	public static void main(String[] args) {
		// 1. Spring Container를 구동한다.
		GenericXmlApplicationContext context =
			new GenericXmlApplicationContext("applicationContext.xml");
		HelloSpring helloSpring = context.getBean("helloSpring", HelloSpring.class);	// 가능한 자바코드를 사용하지 않기 위해 bean 객체를 사용한다.
		helloSpring.menu();
		
		context.close();
	
	}
}
