import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Exam2 {

	public static void main(String[] args) {
		// 서버 만들기
		ServerSocket ss = null;
		// 특정 컴퓨터에 접속하기
		Socket soc = null;
		
		try {
			// ServerSocket(포트번호)
			ss = new ServerSocket(12345);
			System.out.println("Server Ready...");
		} catch (IOException e) {
			System.out.println("해당 포트가 열려 있습니다.");
			System.exit(0);
		}
		
		try {
			// 클라이언트로 부터 들어오는 정보를 기다리는 Method
			soc = ss.accept();
			System.out.println("접속자 정보 : " + soc.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}















