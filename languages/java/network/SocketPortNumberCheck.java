package languages.java.network;

import java.io.IOException;
import java.net.ServerSocket;

public class SocketPortNumberCheck {
    public static void main(String[] args) {
        ServerSocket ss = null;
        for(int i = 0; i < 65536; i++) {
            try {
                ss = new ServerSocket(i);
                ss.close();
            } catch (IOException e) {
                System.out.println("["+i+"] already userd.");
            }
        }
    }
}
