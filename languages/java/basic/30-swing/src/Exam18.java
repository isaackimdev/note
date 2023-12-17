import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class Swing18 extends JFrame implements ActionListener {
	// 선언
	Container container = getContentPane();
	JTextArea textArea = new JTextArea("abcdefghijklmnopqrstuvwxyz");
	JScrollPane scrollPane = new JScrollPane(textArea);	// 텍스트 에어리아에 마우스 스크롤 줌
	JLabel label1 = new JLabel("ID : " , JLabel.RIGHT);
	JLabel label2 = new JLabel("Pass : " , JLabel.RIGHT);
	JTextField textField = new JTextField();
	JPasswordField passwordField = new JPasswordField();
	
	// 초기화 : 생성자 
	public Swing18() {
		setTitle("swing");
		setSize(300,200);
		setLocation(300,300);
		init();
		start();
		setVisible(true);
	}
	// 화면 구성
	private void init() {
		container.setLayout(new BorderLayout());
		JPanel panel1 = new JPanel(new BorderLayout());
		panel1.add("West", label1);
		// JTextField의 글자 배치를 중앙으로 설정
		textField.setHorizontalAlignment(JTextField.CENTER);
		panel1.add("Center", textField);
		container.add("North", panel1);
		container.add("Center",scrollPane);
		
		JPanel panel2 = new JPanel(new BorderLayout());
		panel2.add("West", label2);
		// 비밀번호를 적을 떄 나타나는 문자 지정. 기본값은 '*';
		passwordField.setEchoChar('%');
		panel2.add("Center", passwordField);
		container.add("South",panel2);
		
	}
	// 이벤트 설정
	private void start() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		passwordField.addActionListener(this);
	}
	// 이벤트 처리
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == passwordField) {
//			String str = passwordField.getText();	// deprecated 조금 후 없어질 명령어 
			String str = new String(passwordField.getPassword());	// 권장함
			textArea.setText(str);
		}
	}
	
}

public class Exam18 {
	public static void main(String[] args) {
		Swing18 swing18 = new Swing18();
	}
}
