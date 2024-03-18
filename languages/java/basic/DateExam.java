package languages.java.basic;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateExam {
    public static void main(String[] args) {
        // ex) 오늘이 '2024년 03월 18일'일 때 -> 20240318 와 같은 8자리 날짜 데이터 출력
        String currentDate = LocalDate.now().format(DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println(currentDate);
    }
}
