package chatting2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer2 {
	// 선언
	ServerSocket serverSocket;		// 채팅서버 만들기
	Socket socket;					// 서버에 연결할 수 있는 소켓(길, 루트)를 만들어 줌.
	List<Thread> list;				// 리스트 제네릭>>> 타입은 Thread 로...	
	
	// 생성자
	public ChatServer2() {
		list = new ArrayList<Thread>();
		System.out.println("서버가 시작되었습니다.");
	}
	public void giveAndTake() {
		
		try {
			serverSocket = new ServerSocket(5420);		// 서버 포트 생성
			// ServerSocket port 바로 다시 사용
			serverSocket.setReuseAddress(true);//
			
			while(true) {
				socket = serverSocket.accept();		// 소켓에다가 연결될 소켓을 기다리겠다는 명력어를 씀 accept();
				ServerSocketThread2 sst = new ServerSocketThread2(this, socket);
				// 리스트 객체에 저장<< 쓰레드를 상속 받은 객체 : ServerSocketThread2를 addCLient>>
				addClient(sst);
				//스레드 시작
				sst.start();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public synchronized void addClient(Thread thread) {			// list에 담은 쓰레드 객체를 동기화 시킴
		list.add(thread);
		System.out.println("Clinet 1명 입장, 총 " + list.size() + "명");
	}
	public synchronized void removeClient(Thread thread) {
		list.remove(thread);
		System.out.println("Client 1명 퇴장, 총" + list.size() + "명");
	}
	public synchronized void broadCasting(String str) {
		for (int i = 0; i<list.size(); i++) {
			ServerSocketThread2 sst2 = (ServerSocketThread2) list.get(i);
			sst2.sendMessage(str);
		}
	}

	
}
