package sample6;

import java.io.FileWriter;
import java.io.IOException;

public class FileOutput implements Outputter {
	// 출력파일에 대한 경로와 파일이름을 저장할 필드
	private String filePath;
	public void setFilePath(String filePath) {
		this.filePath = filePath;
		System.out.println("2. 파일 경로와 파일 이름 설정");
	}
	
	@Override
	public void output(String message) throws IOException {
		FileWriter out = new FileWriter(filePath);	// 문자열 형태로 그냥 저장 and Stream은 byte[]로 저장
		out.write(message);
		out.close();
		System.out.println("5. 파일 전송 성공");
	}

}
