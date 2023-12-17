package chatting2;

import java.io.*;
import java.net.*;

public class ServerSocketThread2 extends Thread{
	Socket socket;		// 각 서버 객체에 연결할 소켓 객체 생성 준비
	ChatServer2 server;	// 서버 객체
	PrintWriter out;	// 쓰기
	BufferedReader in;	// 읽기
	
	String name;
	String threadName= "Thread";
	
	// 생성자
	public ServerSocketThread2(ChatServer2 server, Socket socket) {
		this.socket = socket;
		this.server = server;
		threadName = getName();
		System.out.println(socket.getInetAddress()+ "님이 입장하였습니다.");
		System.out.println("Thread Name : " + threadName);
	}
	public void sendMessage(String str) {
		out.println(str);
	}
	@Override
	public void run() {
		try {
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())));
			
			sendMessage("대화자 이름을 넣으세요 : ");
			name = in.readLine();
			server.broadCasting("[" + name + "] 님이 입장하셨습니다.");
			
			while(true) {
				String strin = in.readLine();
				server.broadCasting("[" + name +"]" + strin);
			}
		
		} catch(IOException e) {
			System.out.println(threadName + "퇴장했습니다.");
			server.removeClient(this);
		} finally {
			try {
				socket.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
}
