import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class Event9 extends Frame implements ActionListener{
	// 선언
	Label labelInput, labelContents ;	// 내용 입력, 선택된 내용
	Panel panelContents;				// 패널 선택된 내용
	Panel conIn;	// 내용 입력 패널
	Panel panelCenter;
	BorderLayout BorderLayout;
	GridLayout gridLayout;
	FlowLayout flowLayout;
	TextArea textArea;	
	TextField textField;
	
	// 생성자 : 초기화
	public Event9() {
		labelInput = new Label("출력");
		labelContents = new Label("입력 :");
		
		panelContents = new Panel();
		conIn = new Panel();
		panelCenter = new Panel();
		
		BorderLayout = new BorderLayout();
		gridLayout = new GridLayout(1, 2);
		flowLayout = new FlowLayout();
		
		textField = new TextField();
		textArea = new TextArea();
		
		setTitle("Java TextField & TextArea");
		setSize(300 , 300);
		setLocation(300, 300);
		
		init();
		start();
		
		setResizable(false);	// 프레임 크기 변경 금지
		setVisible(true);
	}
	
	// 화면 설정
	private void init() {
		// Frame Layout 설정
		setLayout(BorderLayout);
		
		// 선택된 내용 만들어주기 panel
		panelContents.setLayout(flowLayout);
		panelContents.add(labelContents);
		panelContents.add(textField);
		
		// 내용 입력 라벨 만들어주기
		conIn.setLayout(new GridLayout(1,1));
		conIn.add(labelInput);
		// 가운데 센터에 TextArea 만들기
		panelCenter.setLayout(new GridLayout(1,1));
		panelCenter.add(textArea);
		textArea.setText("안녕\n자바\n화창한 가을\n");

		// frame 배치	1. 선택된 내용 남쪽에 배치
		add("South", panelContents);
		add("North",conIn);
		add("Center",panelCenter);
		
	}
	// 이벤트 설정
	private void start() {
		
		// x창 종료
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
				super.windowClosing(e);
			}
		});
	}
	// 이벤트 처리
	@Override
	public void actionPerformed(ActionEvent e) {
		String str = textArea.getText();
		
		
	}
	
}
public class Exam9 {
	public static void main(String[] args) {
		Event9 event9 = new Event9();
	}
}
