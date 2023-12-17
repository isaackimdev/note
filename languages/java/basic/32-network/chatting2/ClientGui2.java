package chatting2;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ClientGui2 extends JFrame implements ActionListener, Runnable {
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
	
	public ClientGui2(String ip, int port) {
		// 화면 초기화 
		setTitle(this.getClass().getName());
		setSize(550, 400);
		setLocation(300, 300);
		init();
		start();
		setVisible(true);
		
		System.out.println(this.getClass().getName() + "1.Start===>");
	}
	private void start() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		textField.addActionListener(this);
	}
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
	@Override
	public void run() {
		System.out.println(getClass().getName() + "4. run==> ");	
		try {
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			while((str = in.readLine()) != null) {
				textArea.append(str+"\n");
			} 
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		textField.requestFocus();
		String input_str = textField.getText();
		out.println(input_str);
		textField.setText("");
	}
	
	public void giveAndTake() {
		System.out.println(getClass().getName() + "3. InpoutOutput==>>");
		
		try {
			out = new PrintWriter(new BufferedWriter(
					new OutputStreamWriter(socket.getOutputStream())), true);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
}
