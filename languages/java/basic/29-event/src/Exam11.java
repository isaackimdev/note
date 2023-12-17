import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class Sub11 extends Frame  {
// 선언
	Label label1 = new Label("결과 출력");
	Label label2 = new Label("입력 : ", Label.RIGHT);
	TextArea textArea = new TextArea("");
	TextField textField = new TextField();
	Panel panel = new Panel();
	// 초기화
	public Sub11() {
		init();
		start();
		
		setTitle("Text");
		setSize(300, 200);
		setLocation(300, 300);
		setVisible(true);
	}
	// 화면구성
	private void init() {
		// frame layout 설정
		setLayout(new BorderLayout());
		add("North", label1);
		add("Center", textArea);
		add("South", panel);
		// panel 구성
		panel.setLayout(new BorderLayout());
		panel.add("West", label2);
		panel.add("Center", textField);
	}
	// 이벤트 설정
	private void start() {
		// 람다 표현식으로 이벤트 처리 2
		textField.addActionListener( e ->
			{
				String str = textField.getText();
				
				if(!textArea.getText().equals("")) {
					str = textArea.getText() + "\n" + str;
				}
				
				textArea.setText(str);
				textField.setText("");
			}	
		);
		// 람다 표현식으로 이벤트 처리 1
//		textField.addActionListener((ActionEvent e) ->
//			{
//				String str = textField.getText();
//				
//				if(!textArea.getText().equals("")) {
//					str = textArea.getText() + "\n" + str;
//				}
//				
//				textArea.setText(str);
//				textField.setText("");
//			}	
//		);
		
		
		// 익명클래스의 방법으로 이벤트 처리 		// 클래스 implement ActionListener 를 삭제
//		textField.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				String str = textField.getText();
//				
//				if(!textArea.getText().equals("")) {
//					str = textArea.getText() + "\n" + str;
//				}
//				
//				textArea.setText(str);
//				textField.setText("");
//			}
//		});
		
		
		
		
		// 프레임 창의 x버튼의 종료 처리
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
				super.windowClosing(e);
			}
		});		
	}
}
	// 이벤트 처리
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		String str = textField.getText();
//		
//		if(!textArea.getText().equals("")) {
//			str = textArea.getText() + "\n" + str;
//		}
//		
//		textArea.setText(str);
//		textField.setText("");
//	}	
//}

public class Exam11 {

	public static void main(String[] args) {
		Sub11 sub11 = new Sub11();
	}

}
