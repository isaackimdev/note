package chatting;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {
	ServerSocket serverSocket;
	Socket socket;
	List<Thread> list;

	public ChatServer() {
		list = new ArrayList<Thread>();
		System.out.println("서버가 시작되었습니다.");
	}
	
	public void giveAndTake() {
		try {
			serverSocket = new ServerSocket(5420);
			//ServerSocket port 바로 다시사용
			serverSocket.setReuseAddress(true);
			
			while(true) {
				socket = serverSocket.accept();
				ServerSocketThread sst = new ServerSocketThread(this, socket);
				// 리스트 객체에 저장
				addClient(sst);
				// 스레드 시작
				sst.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public synchronized void addClient(Thread thread) {
		list.add(thread);
		System.out.println("Client 1명 입장, 총 " + list.size() + "명");
	}
	
	public synchronized void removeClient(Thread thread) {
		list.remove(thread);
		System.out.println("Client 1명 퇴장, 총 " + list.size() + "명");
	}
	
	public synchronized void broadCasting(String str) {
		for(int i=0; i<list.size(); i++) {
			ServerSocketThread sst = (ServerSocketThread) list.get(i);
			sst.sendMessage(str); 
		}
	}
}













