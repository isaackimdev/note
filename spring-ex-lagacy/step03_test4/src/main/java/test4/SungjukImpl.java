package test4;

import java.util.Scanner;

public class SungjukImpl implements Sungjuk{
	SungjukDTO sungjukDTO;
	
	public SungjukImpl(SungjukDTO sungjukDTO) {
		super();
		this.sungjukDTO = sungjukDTO;
	}

	@Override	// 총점계산
	public void calcTot() {
	sungjukDTO.setTot(
			sungjukDTO.getKor()+
			sungjukDTO.getEng()+
			sungjukDTO.getMath()
			);
	}

	@Override	// 평균계산
	public void calcAvg() {
		sungjukDTO.setAvg((double)sungjukDTO.getTot()/3);
	}

	@Override	// 출력
	public void display() {
		System.out.printf("%s\t%s\t%s\t%s\t%s\t%s\t\n",
			"이름","국어","영어","수학","총점","평균");
		System.out.printf("%s\t%d\t%d\t%d\t%d\t%.1f\t\n",
			sungjukDTO.getName(), sungjukDTO.getKor(),
			sungjukDTO.getEng(), sungjukDTO.getMath(),
			sungjukDTO.getTot(), (double)sungjukDTO.getAvg());
	}

	@Override	// 수정
	public void modify() {
		Scanner sc = new Scanner(System.in);
		System.out.print("\n이름 입력 : ");
		sungjukDTO.setName(sc.next());
		System.out.print("국어 입력 : ");
		sungjukDTO.setKor(sc.nextInt());
		System.out.print("영어 입력 : ");
		sungjukDTO.setEng(sc.nextInt());
		System.out.print("수학 입력 : ");
		sungjukDTO.setMath(sc.nextInt());
		System.out.println();
		
		calcTot();
		calcAvg();
	}

}
