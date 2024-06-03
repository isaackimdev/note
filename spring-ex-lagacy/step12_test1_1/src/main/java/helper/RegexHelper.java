package helper;

import java.util.regex.Pattern;

public class RegexHelper {
	// ------------ 싱글톤 객체 생성 시작 -----------------
	
	private static RegexHelper instance = null;
	
	public static RegexHelper getInstance() {
		if(instance == null) instance = new RegexHelper();
		
		return instance;
	}
	// 생성자를 private으로 작성하면 new에 의한 객체 생성이 불가능해 진다.
	private RegexHelper() {}
	// ------------ 싱글톤 객체 생성 끝 ------------------
	/**
	 * 주어진 문자열이 공백이거나 null인지를 검사
	 * @param str - 검사할 문자열
	 * @return boolean - 공백, null이 아닐 경우 true 리턴
	 */
	public boolean isValue(String str) {
		boolean result = false;
		if(str != null) {
			result = !str.trim().equals("");	// trim 앞뒤 공백을 자르고
		}
		return result;
	}
	/**
	 * 숫자 모양에 대한 형식 검사
	 * @param str - 검사할 문자열
	 * @return - boolean - 형식에 맞는 경우 true, 맞지 않을 경우 false
	 */
	public boolean isNum(String str) {
		boolean result = false;
		if(isValue(str)) {
			// 숫자로만 되어 있으면 true 아니면 false
			result = Pattern.matches("^[0-9]*$", str);	
		}
		return result;
	}
	/**
	 * 한글로만 구성되었는지에 대한 형식 검사
	 * @param str - 검사할 문자열
	 * @return boolean - 형식에 맞는 경우 true, 맞지 않을 경우 false 
	 */
	public boolean isKor(String str) {
		boolean result = false;
		if(isValue(str)) {
			result = Pattern.matches("^[ㄱ-ㅎ가-힣]*$", str);	
		}
		return result;
	}
	/**
	 * 영어로만 구성되었는지에 대한 형식 검사
	 * @param str - 검사할 문자열
	 * @return boolean - 형식에 맞는 경우 true, 맞지 않을 경우 false 
	 */
	public boolean isEng(String str) {
		boolean result = false;
		if(isValue(str)) {
			result = Pattern.matches("^[a-zA-Z]*$", str);	
		}
		return result;
	}
}