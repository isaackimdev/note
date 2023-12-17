import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

public class Exam3 {

	public static void main(String[] args) {
		// 읽을 파일의 경로
		String path = "test1.txt";
		// 읽은 내용이 담겨질 스트림 (byte[])
		byte[] data = null;
		// 읽은 내용이 변환될 문자열
		String read_string = null;
		/** 파일 읽기 */
		InputStream in = null;
		
		try {
			// 경로를 확인하고, 파일을 오픈함
			in = new FileInputStream(path);
			// 읽은 내용을 담기 위한 배열은 파일의 용량만큼 사이즈를 할당한다.
			// in.available() --> 열려 있는 파일의 크기
			data = new byte[in.available()];
			// 파일 읽기 - 파라미터로 전달된 배열 안에, 파일의 내용을 담아준다.
			in.read(data);
			System.out.println("[INFO] 파일 읽기 성공 >> " + path);
		} catch (FileNotFoundException e) {
			System.out.println("[ERROR] 저장 경로를 찾을 수 없습니다. >> " + path);
			//e.printStackTrace();
		} catch (IOException e) {
			System.out.println("[ERROR] 파일 읽기에 실패했습니다. >> " + path);
			//e.printStackTrace();
		} catch (Exception e) {
			System.out.println("[ERROR] 알수없는 에러가 발생했습니다. >> " + path);
			//e.printStackTrace();
		} finally {
			if(in != null) {
				try {
					in.close();
				} catch (IOException e) {
					System.out.println("[ERROR] 파일 닫기 실패");
					//e.printStackTrace();
				}
			}
		}
		
		// data 배열에 내용이 있다면, 문자열로 변환하여 출력
		if(data != null) {
			// 문자열로 변환시에는 저장된 인코딩으로 지정해 준다.
			try {
				read_string = new String(data, "utf-8");
				System.out.println(read_string);
			} catch (UnsupportedEncodingException e) {
				System.out.println("[ERROR] encoding 지정 에러");
				//e.printStackTrace();
			}
			
		}
	}

}









