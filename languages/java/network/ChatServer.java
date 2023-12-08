package languages.java.network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * ChatServer
 */
public class ChatServer extends Thread {

    public static void main(String[] args) {
        new ChatServer();
    }

    // variable
    ServerSocket ss = null;
    Socket socket = null;

    BufferedReader br = null;
    
    PrintWriter pw = null;
    Scanner sc = null;
    
    // 생성자
    public ChatServer() {
        try {
            ss = new ServerSocket(12345);
            System.out.println("server run...");

            socket = ss.accept();
            System.out.println("connection client...");

            this.start();
            System.out.println("server thread start...");
            
            sc = new Scanner(System.in);

            // 메시지 작성하는 writer
            pw = new PrintWriter(
                new BufferedWriter(
                    new OutputStreamWriter(
                        socket.getOutputStream()
                    )
                )
            );

            
            while (true) {
                // 메시지 입력
                System.out.print("server : " );
                String msg = sc.nextLine();
                // 메시지 전송
                pw.println(msg);
                pw.flush();             
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        // 메시지 받는 reader
        try {
            br = new BufferedReader(
                new InputStreamReader(
                    socket.getInputStream()
                )  
            );

            while (true) {
                // 메시지 받기
                String recivedMsg = br.readLine();
                System.out.println("revived msg : " + recivedMsg);
            }
        } catch (IOException e) {
            System.out.println("받기 error");
        }
    }
}