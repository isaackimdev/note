
public class Exam1 {
	public static void main(String[] args) {
	// 1. 자식 기준
	Army aa = new Army("육군");
	Navy nn = new Navy("해군");
	AirForce af = new AirForce("공군");
	aa.move();
	aa.attack();
	nn.move();
	nn.attack();
	af.move();
	af.attack();
	System.out.println("-----------------");
	// 2. 부모 기준 => 객체배열 사용
	
	Unit[] unit = new Unit[3];	// 배열만 생성됨.
	
	unit[0] = new Army("육군");		// 생성자 New로 호출해야만 사용 가능
	unit[1] = new Navy("해군");		// 생성자 New로 호출해야만 사용 가능
	unit[2] = new AirForce("공군"); // 생성자 New로 호출해야만 사용 가능
		for(int x=0; x<unit.length; x++) {
			unit[x].attack();
			unit[x].move();
		}
	}
	
}
