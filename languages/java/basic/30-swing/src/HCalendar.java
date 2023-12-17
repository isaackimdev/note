import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JPanel;

public class HCalendar {
	JButton[] buttons;
	Calendar calendar;
	int year, month;
	
	public HCalendar() {
		calendar = Calendar.getInstance();
		year = calendar.get(Calendar.YEAR);
		month = calendar.get(Calendar.MONTH) + 1;	
	}
	public void setButtons(JButton[] buttons) {
		this.buttons = buttons;
	}
	// Label에 출력할 문자열
	public String getCalText() {
		return year + "년 " + month + "월";
	}
	// 달력을 새로운 년월로 새로 그리기
	public void allInit(int gap) {
		// 버튼의 날짜 지우기
		for(int i=7; i<buttons.length; i++) {
			buttons[i].setText("");
		}
		calInput(gap);
		calSet();
	}
	// 년월 수정
	public void calInput(int gap) {
		month += gap;
		if(month <= 0) {
			month = 12;
			year--;
		} else if(month >= 13) {
			month = 1;
			year++;
		}
	}
	// 버튼에 날짜 설정하기	
	public void calSet() {
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, (month -1));
		calendar.set(Calendar.DATE, 1);
		// 1일이 시작되는 요일수 = 요일수  - 1 
		// (요일수가 1부터 시작, 배열은 0부터 시작)
		int firstDay = calendar.get(Calendar.DAY_OF_WEEK) - 1;
		for(int i=1; i<=calendar.getActualMaximum(Calendar.DATE); i++) {
			// buttons[0]~[6] : 일~토
			// 그달의 1일은 buttons[6 + (요일수-1) + i일]
			buttons[6 + firstDay + i].setText(String.valueOf(i));
		}
	}	
}












