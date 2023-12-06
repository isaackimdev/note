package languages.java.network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args) {
        // TCP Server
        ServerSocket ss = null;
        Socket soc = null;

        try {
            ss = new ServerSocket(12345);
            System.out.println("server run");

            soc = ss.accept();
            System.out.println("connector : " + soc.toString());

            BufferedReader br = new BufferedReader(
                new InputStreamReader(
                    soc.getInputStream()
                )
            );

            String msg = br.readLine();
            System.out.println("recived msg");
            System.out.println(msg);


            PrintWriter pw =
            new PrintWriter(
                new BufferedWriter(
                    new OutputStreamWriter(
                        soc.getOutputStream()
                    )
                )
            );

            pw.println("server -> client : [" +msg +"]\n");
            pw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
