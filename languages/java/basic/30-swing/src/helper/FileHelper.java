package helper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

public class FileHelper {
	//--- 싱글톤 객체 생성 시작 ---
	private static FileHelper instance = null;
	
	public static FileHelper getInstance() {
		if(instance == null) {
			instance = new FileHelper();
		}
		return instance;
	}
	
	public static void freeInstance() {
		instance = null;
	}
	
	private FileHelper() {}
	//--- 싱글톤 객체 생성 끝 -----
	/**
	 * 주어진 경로에 data 값을 기록하고 저장한다.
	 * @param filePath - 저장할 파일 경로
	 * @param data - 저장할 내용을 담을 스트림
	 * @return boolean - 성공시 true, 실패시 false
	 */
	public boolean write(String filePath, byte[] data) {
		boolean result = false;
		/** 파일 저장 절차 시작 */
		OutputStream out = null;
		try {
			out = new FileOutputStream(filePath);
			// 파일 쓰기
			out.write(data);
			System.out.println("[INFO] 파일 저장됨 >> " + filePath);
			// 파일 저장 성공
			result = true;
		} catch (FileNotFoundException e) {
			System.out.println("[ERROR] 저장 경로를 찾을 수 없음 >>" + filePath);
			//e.printStackTrace();
		} catch (IOException e) {
			System.out.println("[ERROR] 파일 저장 실패 >>" + filePath);
			//e.printStackTrace();
		} catch (Exception e) {
			System.out.println("[ERROR] 알 수 없는 에러 >>" + filePath);
			//e.printStackTrace();
		} finally {
			try {
				if(out != null) out.close();
			} catch(IOException e) {
				System.out.println("[ERROR] 파일 닫기 실패 >> " + filePath);
			}
		}
		
		return result;
	}
	/**
	 * 문자열을 byte[]로 변환한 뒤, 파일에 저장한다.
	 * @param filePath - 저장할 파일 경로
	 * @param content - 저장할 내용
	 * @param encType - 인코딩 형식
	 * @return boolean - 성공시 true, 실패시 false
	 */
	public boolean writeString(String filePath, String content, String encType) {
		boolean result = false;
		byte[] data = null;
		
		try {
			// 문자열을 byte[] 변환
			data = content.getBytes(encType);
		} catch (UnsupportedEncodingException e) {
			System.out.println("[ERROR] 인코딩 지정 에러");
			//e.printStackTrace();
		} catch (Exception e) {
			System.out.println("[ERROR] 알 수 없는 에러");
			//e.printStackTrace();
		}
		
		result = this.write(filePath, data);
		return result;
	}
	/**
	 * 주어진 경로의 파일을 읽고, 내용을 스트림으로 리턴한다.
	 * @param filePath - 읽어야 할 파일의 경로
	 * @return 읽혀진 내용
	 */
	public byte[] read(String filePath) {
		byte[] data = null;
		/** 파일 읽기 */
		InputStream in = null;
		
		try {
			in = new FileInputStream(filePath);
			// 읽은 내용을 담기 위한 배열은 파일의 용량만큼 사이즈를 할당한다.
			// in.available() --> 열려 있는 파일의 크기
			data = new byte[in.available()];
			// 파일 읽기 - 파라미터로 전달된 배열 안에, 파일의 내용을 담아준다.
			in.read(data);
			System.out.println("[INFO] 파일 읽기 성공 >> " + filePath);
		} catch (FileNotFoundException e) {
			System.out.println("[ERROR] 저장 경로를 찾을 수 없음 >> " + filePath);
			//e.printStackTrace();
		} catch (IOException e) {
			System.out.println("[ERROR] 파일 읽기 실패 >> " + filePath);
			//e.printStackTrace();
		} catch (Exception e) {
			System.out.println("[ERROR] 알 수 없는 에러 >> " + filePath);
			//e.printStackTrace();
		} finally {
			try {
				if(in != null) in.close(); // 파일 스트림 닫기
			} catch (IOException e) {
				System.out.println("[ERROR] 파일 닫기 실패 >> " + filePath);
			}
		}
		
		return data;
	}
	/**
	 * 파일의 내용을 문자열로 리턴한다.
	 * @param filePath - 읽어야 할 파일의 경로
	 * @param encType - 인코딩 형식
	 * @return String - 읽은 내용에 대한 문자열
	 */
	public String readString(String filePath, String encType) {
		String content = null;
		byte[] data = this.read(filePath);
		// 내용을 문자열로 변환한다.		
		try {
			content = new String(data, encType);
		} catch (UnsupportedEncodingException e) {
			System.out.println("[ERROR] 인코딩 지정 에러");
			//e.printStackTrace();
		} catch (Exception e) {
			System.out.println("[ERROR] 알 수 없는 에러");
			//e.printStackTrace();
		}
		
		return content;
	}
}










