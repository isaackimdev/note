package sample4;

import java.util.Calendar;

abstract public class AbstractTest {	
	 /*인터페이스를 쓰지않고, 추상클래스를 쓴다면, 
	 어떤 함수는 만들어 놓기만하고,
	 어떤 함수는 만들어 쓰겠다는 의미*/
	
	abstract public String dayInfo();
	
	public static AbstractTest getInstance() {
		Calendar cal = Calendar.getInstance(); 	// 객체를 가지고 옴
		int day = cal.get(Calendar.DAY_OF_WEEK);	// 요일 수 : 일 1, 월 2, 화 3, 수 4, 목 5, 
		switch (day) {
		case 1: return new Sunday();
		case 2: return new Monday();
		case 3: return new Tuesday();
		case 4: return new Wednesday();
		case 5: return new Thursday();
		case 6: return new Friday();
		case 7: return new Saturday();
		}
		
		return null;
	}
}
