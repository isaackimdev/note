import java.util.Calendar;
public class Exam1 {
	public static void main(String[] args) {
		// 캘린더 객체의 생성 --> 싱글톤 객체
		Calendar cal = Calendar.getInstance();
		
		System.out.println(cal);			// 1) toString() 이 생략되어 있음
		//System.out.println(cal.toString()); // 2) 1)과 같음
		
		// toSring() 멤버변수를 보여주는 역할
		// toSring() 은 Object에 있다.
		
		// 년, 월, 일, 시, 분, 초 >> 24시간제
		int yy = cal.get(Calendar.YEAR);
		int mm = cal.get(Calendar.MONTH) + 1;	// 자바에서의 월은 0부터 시작된다.
		int dd = cal.get(Calendar.DAY_OF_MONTH);
		int hh = cal.get(Calendar.HOUR_OF_DAY);
		int mi = cal.get(Calendar.MINUTE);
		int ss = cal.get(Calendar.SECOND);
		
		System.out.printf("%04d년 %02d월 %02d일 %02d시 %02d분 %02d초",
				yy, mm, dd, hh, mi, ss);
		// 년, 월, 일, 시, 분, 초 >> 12시간제
		hh = cal.get(Calendar.HOUR);
		// 오전(=0), 오후(=1)
		int ampm = cal.get(Calendar.AM_PM);
		String[] apname = {"오전", "오후"};
		System.out.println();
		System.out.printf("%04d년 %02d월 %02d일 %s %02d시 %02d분 %02d초",
				yy, mm, dd, apname[ampm], hh, mi, ss);		
		
	}
}
//java.util.GregorianCalendar
//[time=1525321097091,areFieldsSet=true,areAllFieldsSet=true,lenient=true,
//zone=sun.util.calendar.ZoneInfo[id="Asia/Seoul",offset=32400000,dstSavings=0,
//useDaylight=false,transitions=22,lastRule=null],firstDayOfWeek=1,
//minimalDaysInFirstWeek=1,ERA=1,YEAR=2018,MONTH=4,WEEK_OF_YEAR=18,
//WEEK_OF_MONTH=1,DAY_OF_MONTH=3,DAY_OF_YEAR=123,DAY_OF_WEEK=5,
//DAY_OF_WEEK_IN_MONTH=1,AM_PM=1,HOUR=1,HOUR_OF_DAY=13,MINUTE=18,SECOND=17,
//MILLISECOND=91,ZONE_OFFSET=32400000,DST_OFFSET=0]
