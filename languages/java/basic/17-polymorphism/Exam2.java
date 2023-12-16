
public class Exam2 {
	public static void main(String[] args) {
		// 부대지정
		Unit[] units = new Unit[5];
		units[0] = new AirForce("공군1호");
		units[1] = new AirForce("공군2호");
		units[2] = new Navy("해군1호");
		units[3] = new Army("육군1호");
		units[4] = new Army("육군2호");
		// 부대 일괄 공격
		for(int i=0 ; i<units.length; i++) {
			units[i].attack();
			// 자식은 부모를 품을 수 없음
			// 자식 형변환을 통해 사용할 수 있음.
			if(units[i] instanceof Army) {// instanceof 현재 저장된 값이 army 의 클래스냐
				Army a = (Army) units[i];
				a.tank();
			} else if(units[i] instanceof Navy) {
				Navy n =
						(Navy) units[i];
				n.nucleus();
			} else {
				AirForce af = 
						(AirForce)units[i];	
				af.bombing();
			}
		}
		
		
	}
}
