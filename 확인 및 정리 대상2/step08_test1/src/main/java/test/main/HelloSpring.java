package test.main;

import java.util.Scanner;

import org.springframework.context.support.GenericXmlApplicationContext;

import test.bean.ScoreVO;
import test.service.ScoreService;
import test.service.ScoreServiceImpl;

public class HelloSpring {
	Scanner scanner = new Scanner(System.in);
	ScoreServiceImpl scoreService;
	int num;
	
	public void menu() {
		
		while(true){
			do {
				System.out.println();
				System.out.println("1.	입력");
				System.out.println("2.	출력");
				System.out.println("3.	수정");
				System.out.println("4.	삭제");
				System.out.println("5.	종료");
				System.out.println("---------");
				System.out.print("번호 : ");
				num = scanner.nextInt();
			} while (num < 1 || num > 5);
			
			if(num == 5) {
				System.out.println("종료합니다.");
				return;	// 반복문을 exit, [ break, return 권장 ]
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
			System.out.println("저장성공");
		} else {
			System.out.println("ㅈ장실패");
		}
		
	}

	private void output() {
		
	}

	private void modify() {
		
	}

	private void delete() {
		
	}

	public static void main(String[] args) {
		// 1. Spring 컨테이너를 구동한다.
		GenericXmlApplicationContext context =
			new GenericXmlApplicationContext("applicationContext.xml");
		// 2. Spring 컨테이너로부터 ScoreServiceImpl 객체를 Lookup한다.
		HelloSpring helloSpring = context.getBean("helloSpring", HelloSpring.class);
		helloSpring.menu();
		
	//	ScoreServiceImpl scoreService = (ScoreServiceImpl) context.getBean("scoreService", ScoreService.class);
		// 3. 성적 등록 기능 테스트
	//	ScoreVO vo = new ScoreVO();
		

		
		/*
		vo.setStudNo("20181");
		vo.setName("홍길동");
		vo.setKor(11);
		vo.setEng(11);
		vo.setMat(11);
		vo.setTot(11);
		vo.setAvg(11.0);
		
		System.out.println(vo.toString());
		
		int r = scoreService.insertScore(vo);
		 */
		
		
		context.close();
	}
}
