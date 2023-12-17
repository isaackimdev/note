import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Exam5 {

	public static void main(String[] args) {
		InetAddress ia = null;
		Socket socket = null;
		PrintWriter out = null;
		
		try {
			ia = InetAddress.getLocalHost();
			socket = new Socket(ia, 12345);
			out = new PrintWriter(
					new BufferedWriter(
							new OutputStreamWriter(socket.getOutputStream())));
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("접속 오류 : " + e.toString());
			System.exit(-1);
		}
		// "\n"은 특정 내용의 전송의 끝을 나타내는 문자이다.
		out.println("홍길동" + "\n");
		out.flush();
		out.close();
	}

}













