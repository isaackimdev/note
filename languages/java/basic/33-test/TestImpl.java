import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class TestImpl implements Test{
	// 선언
	Scanner sc = new Scanner(System.in);
	private List<TestVO> list = 
			new ArrayList<TestVO>();	// beans 컬렉션
	
	@Override	// 등록
	public void input() {
		TestVO vo = new TestVO();	// 빈즈 클래스 생성
		System.out.println("<< 등록하기 >>");
		System.out.print("[1]이  름 : ");
		vo.setName(sc.next());
		System.out.print("[2]직  급 : ");
		vo.setPosition(sc.next());
		System.out.print("[3]기본급 : ");
		vo.setBasicPay(sc.nextInt());
		System.out.print("[4]수  당 : ");
		vo.setSudang(sc.nextInt());
		
		// 세율 설정하기
		int tot = vo.getBasicPay() + vo.getSudang(); //기본급 + 수당
		//세율은 200만원 이하 : 1%(0.01), 400만원 이하 : 2%(0.02), 
		//400만원 초과 : 3%(0.03)으로 설정한다.
		if(tot <= 2000000 ) {
			vo.setTaxRate(0.01);
		} else if(tot > 2000000 && tot <= 4000000) {
			vo.setTaxRate(0.02);
		} else if(tot > 4000000) {
			vo.setTaxRate(0.03);
		}
		//월급은 “기본급 + 수당 - (기본급 + 수당) * 세율”로 계산을 한다.
		vo.setSalary((int)(vo.getBasicPay()+vo.getSudang()
		- (vo.getBasicPay() + vo.getSudang())*vo.getTaxRate()));
		
		list.add(vo);	// 빈즈 컬렉션 추가
	}	
	
	@Override
	public void printTitle() {
		String str = String.format("%10s %10s %10s %10s %10s %10s",
				"name", "position", "basicPay", "sudang", "taxRate", "salary");
		System.out.println(str);
	}
	@Override	// 출력
	public void print() {
		printTitle();
		Iterator<TestVO> it = list.iterator();
		while(it.hasNext()) {
			System.out.println(it.next().toString());
		}
		System.out.println();
	}
	@Override
	public void edit() {
		// 수정 ; 특정 직원의 직급, 기본급, 수당을 입력받아서 수정한다.
		String name;
		System.out.print("수정할 사원 이름을 입력해주세요 : ");
		name = sc.next();
		
		Iterator<TestVO> it = list.iterator();
		while(it.hasNext()) {
			TestVO vo = it.next();
			if(vo.getName().equals(name)) {	// 입력한 이름이 같은 경우 실행
				System.out.print("수정된 직급을 입력해주세요 : ");
				vo.setPosition(sc.next());
				System.out.print("수정된 기본급을 입력해주세요 : ");
				vo.setBasicPay(sc.nextInt());
				System.out.print("수정된 수당을 입력해주세요 : ");
				vo.setSudang(sc.nextInt());

				// 세율 설정하기
				int tot = vo.getBasicPay() + vo.getSudang(); //기본급 + 수당
				//세율은 200만원 이하 : 1%(0.01), 400만원 이하 : 2%(0.02), 
				//400만원 초과 : 3%(0.03)으로 설정한다.
				if(tot <= 2000000 ) {
					vo.setTaxRate(0.01);
				} else if(tot > 2000000 && tot <= 4000000) {
					vo.setTaxRate(0.02);
				} else if(tot > 4000000) {
					vo.setTaxRate(0.03);
				}	
				
				// 월급 수정
				vo.setSalary((int)(vo.getBasicPay()+vo.getSudang()
				- (vo.getBasicPay() + vo.getSudang())*vo.getTaxRate()));

				printTitle();
				System.out.println(vo.toString());
				System.out.println();
			}
		}
	}
	@Override
	public void searchName() {
		System.out.print("검색할 사원 이름을 입력해주세요 : ");
		String name = sc.next();
		
		Iterator<TestVO> it = list.iterator();
		while(it.hasNext()) {
			TestVO vo = it.next();
			if(vo.getName().equals(name)) {	// 입력한 이름과 같을 경우 실행(출력)
				printTitle();
				System.out.println(vo.toString());
				System.out.println();
			}
		}
	}
}
