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
import java.util.Scanner;

public class ChatClient extends Thread {
   
    public static void main(String[] args) {
        new ChatClient();
    }

    InetAddress ia = null;
    Socket socket = null;
    Scanner sc = null;
    PrintWriter pw = null;
    BufferedReader br = null;

    public ChatClient() {
        try {
            ia = InetAddress.getByName("localhost");
            socket = new Socket(ia, 12345);
            
            this.start();
            System.out.println("Client Thread start");


            sc = new Scanner(System.in);
            pw = new PrintWriter(
                new BufferedWriter(
                    new OutputStreamWriter(
                        socket.getOutputStream()
                    )
                )
            );
            
            while (true) {
                // 메시지 입력
                System.out.print("client : ");
                String msg = sc.nextLine();
                // 메시지 전송
                pw.println(msg);
                pw.flush();    
            }

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            br = new BufferedReader(
                new InputStreamReader(
                    socket.getInputStream()
                )
            );
            // 서버로부터 메시지 받기
            while (true) {
                String revicedMsg = br.readLine();
                System.out.println("msg from server : "+revicedMsg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
   
    }
}
