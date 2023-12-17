import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Exam3 {

	public static void main(String[] args) {
		// IP 주소 관리
		InetAddress ia = null;
		// 특정 컴퓨터에 접속하기
		Socket socket = null;
		
		try {
			ia = InetAddress.getLocalHost();
			socket = new Socket(ia, 12345);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("접속 오류 : " + e.toString());
			System.exit(-1);
		}
		
	}

}














