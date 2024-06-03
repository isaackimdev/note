package test.main;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Component;

import test.bean.ScoreVO;
import test.service.ScoreServiceImpl;

@Component
public class HelloSpring {
	@Autowired
	ScoreServiceImpl scoreService;
	Scanner scanner = new Scanner(System.in);
	
	public void menu() {
		int num = 0;
		
		while (true) {
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
			} while (num < 1 || num > 5 );
			
			if(num == 5) {
				System.out.println("종료합니다.");
				return;	// 반복문을 exit, [ break, return 권장 ]
			}
			
			switch(num) {
			case 1 :	// 입력
				input();
				break;
			case 2 :	// 입력
				output();
				break;
			case 3 :	// 입력
				modify();
				break;
			case 4 :	// 입력
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
		vo.setAvg((double)tot/3 );
		
		result = scoreService.insertScore(vo);
		
		if(result > 0) {
			System.out.println("저장 성공");
		} else {
			System.out.println("저장 실패");
		}
		
	}
	private void output() {
		List<ScoreVO> list = scoreService.getScoreList(null);
		for(ScoreVO vo : list) {	// 모든 데이터를 출력할떄, 사용법 : 일반 포문, 이터레이터, 확장 포문]
			System.out.println(vo.toString());
		}
	}
	private void modify() {
		ScoreVO vo = new ScoreVO();
		int result = 0 ;
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
		GenericXmlApplicationContext context =
			new GenericXmlApplicationContext("applicationContext.xml");
		HelloSpring helloSpring = context.getBean("helloSpring", HelloSpring.class);
		helloSpring.menu();
		
		context.close();	
		
	}
	
	
}
