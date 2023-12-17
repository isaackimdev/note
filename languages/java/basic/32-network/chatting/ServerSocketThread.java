package chatting;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerSocketThread extends Thread{
	Socket socket;
	ChatServer server;
	PrintWriter out;
	BufferedReader in;
	String name;
	String threadName = "Thread";
	
	public ServerSocketThread(ChatServer server, Socket socket) {
		this.socket = socket;
		this.server = server;
		threadName = getName();
		System.out.println(socket.getInetAddress() + "님이 입장하였습니다.");
		System.out.println("Thread Name : " + threadName);
	}
	
	public void sendMessage(String str) {
		out.println(str);
	}
	
	@Override
	public void run() {
		try {
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(new BufferedWriter(
					new OutputStreamWriter(socket.getOutputStream())), true);
			
			sendMessage("대화자 이름을 넣으세요: ");
			name = in.readLine();
			server.broadCasting("[" + name + "]님이 입장하셨습니다.");
			
			while(true) {
				String strin = in.readLine();
				server.broadCasting("[" + name + "]" + strin);
			}
		} catch (IOException e) {
			System.out.println(threadName + " 퇴장했습니다.");
			server.removeClient(this);
		} finally {
			try {
				socket.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}















