package chatting;

public class ClientGuiMain {
	public static void main(String[] args) {
		// "127.0.0.1" : 자기 PC의 기본 ip 주소
		ClientGui clientGui = new ClientGui("127.0.0.1", 5420);
		clientGui.giveAndTake();
	}

}
