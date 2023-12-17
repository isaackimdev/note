import java.awt.BorderLayout;
import java.awt.Container;

import java.awt.FlowLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;

class Swing09 extends JFrame implements ActionListener {
	// 선언
	Container container = getContentPane();
	FlowLayout flowLayout = new FlowLayout();
	JLabel jLabel = new JLabel("ID : ");
	JTextField jTextField = new JTextField(10);	// 사이즈....
	
	JDialog jDialog = new JDialog(this, "확인");
	Container dialogContainer;
	JLabel dialogLabel = new JLabel("사용할 수 있는 ID 입니다.", JLabel.CENTER);
	BorderLayout borderLayout = new BorderLayout();
	// 초기화
	public Swing09 (){
		setTitle("swing");
		setSize(300,200);
		setLocation(300,300);
		init();
		start();
		setVisible(true);
	}
	// 화면 구성
	private void init() {
		container.setLayout(flowLayout);
		container.add(jLabel);
		container.add(jTextField);
		//JDialog를 위한 작업 영역을 얻어낸다.
		dialogContainer = jDialog.getContentPane();
		dialogContainer.setLayout(borderLayout);
		dialogLabel.setBorder(new BevelBorder(BevelBorder.RAISED));	// 양각
		dialogContainer.add("Center", dialogLabel);
		jDialog.setSize(200, 180);
		jDialog.setLocation(400, 400);
		
	}
	// 이벤트 설정
	private void start() {
		// x 닫기 
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// JDialog의 X버튼에 대한 기능을 사용하는 메소드이다. 숨김기능만 처리한다.
		jDialog.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		// textField 이벤트 설정
		jTextField.addActionListener(this);
	}
	// 이벤트 처리
	@Override
	public void actionPerformed(ActionEvent e) {
		// Dialog 생성
		if(e.getSource() == jTextField ) {
			String str = "";
			str = jTextField.getText();
			str = str + "은 사용할 수 있는 ID 입니다.";
			dialogLabel.setText(str);
			jDialog.setVisible(true); // 화면 띄우기
		}
		
	}
	
	
}
public class Exam09 {

	public static void main(String[] args) {
		Swing09 swing09 = new Swing09();
	}

}
