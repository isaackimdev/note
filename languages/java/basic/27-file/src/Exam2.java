import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

public class Exam2 {

	public static void main(String[] args) {
		String path = "test1.txt";
		// 파일에 저장할 내용
		String write_string = "가나다라마바사\nabcdefg";
		/** 특정 인코딩 방식 적용 */
		// 객체나 배열이 선언과 할당에 대한 블록이 서로 분리되어 있을 경우
		// 명시적으로 빈 영역임을 알리기 위해 null로 초기화 한다.
		byte[] buffer = null;
		
		// 문자열을 "utf-8"로 인코딩해서 저장 => 영어, 숫자 : 1byte, 한글 : 3byte
		try {
			buffer = write_string.getBytes("utf-8");
		} catch (UnsupportedEncodingException e) {
			System.out.println("encoding 지정 에러");
			//e.printStackTrace();
		}
		/** 파일 저장 절차 시작 */
		OutputStream out = null;
		// 파일이 없으면 파일을 만들면서, 오픈시킴
		try {
			out = new FileOutputStream(path, true);
			out.write(buffer);
			System.out.println("[INFO] 파일 저장됨 >> " + path);
		} catch (FileNotFoundException e) {
			System.out.println("[ERROR] 저장 경로를 찾을 수 없습니다.");
			//e.printStackTrace();
		} catch (IOException e) {
			System.out.println("[ERROR] 저장에 실패했습니다.");
			//e.printStackTrace();
		} catch (Exception e) {
			System.out.println("[ERROR] 알 수 없는 에러가 발생했습니다.");
			//e.printStackTrace();
		} finally {
			if(out != null) {
				try {
					out.close();
				} catch (IOException e) {
					System.out.println("파일 닫기 실패");
					//e.printStackTrace();
				}	// 파일 스트림 닫기
			}
		}
	}

}






