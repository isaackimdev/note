package chatting;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ClientGui extends JFrame implements ActionListener, Runnable {
	Container container = getContentPane();
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	JTextField textField = new JTextField(50);
	JTextArea textArea = new JTextArea(20, 50);
	JScrollPane scrollPane = new JScrollPane(textArea);
	Socket socket;
	PrintWriter out;
	BufferedReader in;
	String str;
	
	public ClientGui(String ip, int port) {
		// 화면 초기화
		setTitle(this.getClass().getName());
		setSize(550, 400);
		setLocation(300, 300);
		init();
		start();
		setVisible(true);
		
		System.out.println(this.getClass().getName() + "1. Start-->");
		// 통신 초기화
		try {
			socket = new Socket(ip, port);
		} catch (Exception e) {
			System.out.println("소켓 생성 실패!!");
		}
		System.out.println(this.getClass().getName() + "2. Socket-->");
	}
	// 화면구성
	private void init() {
		container.setLayout(new BorderLayout());
		panel1.setLayout(new BorderLayout());
		panel2.setLayout(new BorderLayout());
		
		panel1.add("Center", scrollPane);
		panel2.add("Center", textField);
		
		container.add("Center", panel1);
		container.add("South", panel2);
		
		textArea.setEditable(false);
		textField.requestFocus();
	}
	// 이벤트 설정
	private void start() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		textField.addActionListener(this);
	}
	// 응답 처리
	@Override
	public void run() {	
		System.out.println(getClass().getName() + "4. run-->");	// 동작 확인용
		try {
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			while((str=in.readLine()) != null) {
				textArea.append(str + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				socket.close();
			} catch(Exception e) {
				e.getMessage();
			}
		}
	}
	// 이벤트 처리
	@Override
	public void actionPerformed(ActionEvent e) {		
		textField.requestFocus();
		String input_str = textField.getText();
		out.println(input_str);
		textField.setText("");
	}
	
	public void giveAndTake() {
		System.out.println(getClass().getName() + "3. InputOutput-->");
		try {
			out = new PrintWriter(new BufferedWriter(
					new OutputStreamWriter(socket.getOutputStream())), true);
			in = new BufferedReader(
					new InputStreamReader(socket.getInputStream()));
			Thread thread = new Thread(this);
			// 클라이언트 스레드 시작
			thread.start();
		} catch (IOException e) {
			//e.printStackTrace();
		}
	}
}
















