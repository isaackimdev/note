package chatting2;

public class ClientGuiMain2 {
	public static void main(String[] args) {
		ClientGui2 c = new ClientGui2("127.0.0.1", 5420);
		c.giveAndTake();
	}
}
