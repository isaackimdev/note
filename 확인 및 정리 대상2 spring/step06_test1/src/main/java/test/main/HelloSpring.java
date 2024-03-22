package test.main;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.support.GenericXmlApplicationContext;

import test.bean.ScoreVO;
import test.dao.ScoreDAO;
import test.service.ScoreService;
import test.service.ScoreServiceImpl;

public class HelloSpring {
	
	public static void main(String[] args) {
		// 1. Spring 컨테이너를 구동한다.
		GenericXmlApplicationContext context =
			new GenericXmlApplicationContext("applicationContext.xml");
		// 2. Spring 컨테이너로부터 객체를 꺼냄
		ScoreService scoreService =
				context.getBean("scoreService", ScoreServiceImpl.class);
		ScoreVO vo = new ScoreVO();

		Scanner sc = new Scanner(System.in);
		int select = 0;
		
		System.out.println("1. 입력");
		System.out.println("2. 출력");
		System.out.println("3. 수정");
		System.out.println("4. 삭제");
		System.out.println("5. 종료");
		System.out.println("------------");
		System.out.print("번호 : ");
		select = sc.nextInt();
		System.out.println("선택하신 번호 : " + select);
		System.out.println("\n\n\n");
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		switch (select) {
		case 1 :
			// 3. 점수 등록
			vo.setStudNo("2018004");
			vo.setName("홍길동");
			vo.setKor(50);
			vo.setEng(60);
			vo.setMat(90);
			int tot = vo.getKor() + vo.getEng() + vo.getMat();
			vo.setTot(tot);
			double avg = (double) tot/3;
			vo.setAvg(avg);
			int result = scoreService.insertScore(vo);
			if(result > 0) {
				System.out.println("점수 등록 성공");
			} else {
				System.out.println("점수 등록 실패");
			}
			break;	// 1. 입력
		case 2 :
			// 4. 점수 상세 보기
			vo.setStudNo("2018002");
			vo = scoreService.getScore(vo);
			if(vo != null) System.out.println(vo.toString());

			// 5. 점수 전체 목록 보기
			System.out.println("-----목록보기------");
			List<ScoreVO> list = scoreService.getScoreList(null);

			for(int i = 0 ; i<list.size(); i++) {
				vo = list.get(i);
				System.out.println(vo.toString());
			}
			break;	// 2. 출력
		case 3 :
			// 4. 점수 수정
			vo.setKor(70);
			vo.setEng(80);
			vo.setMat(90);
			tot = vo.getKor() + vo.getEng() + vo.getMat();
			vo.setTot(tot);
			avg = (double) tot/3;
			vo.setAvg(avg);
			// 변경하고자 하는 학생번호
			vo.setStudNo("2018003");
			result = scoreService.updateScore(vo);
			if(result > 0) {
				System.out.println("점수 수정 성공");
			} else {
				System.out.println("점수 수정 실패");
			}
			break;	// 3. 수정
		case 4 :
			// 4. 점수 삭제
			vo.setStudNo("2018006");
			result = scoreService.deleteScore(vo);
			if(result > 0) {
				System.out.println("점수 삭제 성공");
			} else {
				System.out.println("점수 삭제 실패");
			}
			break;	// 4. 삭제
		case 5 :
			System.out.println("프로그램이 종료되었습니다.");
			context.close();
			System.exit(0);

			break;  // 5. 종료
		default :  if(select < 1 || select > 5)
			System.out.println("1~5 사이의 숫자 입력");
			break;
		}
		
		// 종료
		context.close();
		
		
	}
	
}
