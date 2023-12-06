package languages.java.network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPClient {
    public static void main(String[] args) throws UnknownHostException {
        // TCP Client
        Socket soc = null;
        InetAddress ia = null;
        
        
        try {
            ia = InetAddress.getByName("localhost");
            soc = new Socket(ia, 12345);

            String msg = "client isaac : Hello";

            PrintWriter pw = 
            new PrintWriter(
                new BufferedWriter(
                    new OutputStreamWriter(
                        soc.getOutputStream()
                    )
                )
            );
            
            // 메시지 보내기
            pw.println(msg + "\n");
            pw.flush();
            
            BufferedReader br = new BufferedReader(
                new InputStreamReader(
                    soc.getInputStream()
                )
            );

            System.out.println("MSG from server  : " + br.readLine());

        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
}
