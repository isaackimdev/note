import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ScoreFrame extends Frame implements ActionListener{
	Button button1, button2;
	Label labelKor, labelEng, labelTot, labelAvg;
	TextField textFieldKor, textFieldEng;
	BorderLayout borderLayout;
	GridLayout gridLayoutBind, gridLayoutButton;
	FlowLayout flowLayoutSubject;
	Panel panelButton, panelKor, panelEng, panelBind;
	
	public ScoreFrame() {		// 생성자 호출
		button1 = new Button("입력");
		button2 = new Button("취소");
		labelKor = new Label("국어");
		labelEng = new Label("영어");
		labelTot = new Label(" 총점 : ");
		labelAvg = new Label(" 평균 : ");
		textFieldKor = new TextField(15);
		textFieldEng = new TextField(25);
		borderLayout = new BorderLayout();
		gridLayoutButton = new GridLayout(1, 2);	// 1행 2열
		gridLayoutBind = new GridLayout(4, 1);		// 4행 1열
		flowLayoutSubject = new FlowLayout(FlowLayout.LEFT);	// 왼쪽 정렬
		panelKor = new Panel();
		panelEng = new Panel();
		panelBind = new Panel();
		panelButton = new Panel();
		// Frame 설정
		setTitle("Panel");
		setSize(300,200);
		setLocation(300,300);
		
		init();
		start();
		
		setVisible(true);
		
	}
	// 화면 구성
	private void init() {
		// Frame layout 설정
		setLayout(borderLayout);
		// 국어 패널 구성 : kor panel constructure
		panelKor.setLayout(flowLayoutSubject);
		panelKor.add(labelKor);
		panelKor.add(textFieldKor);
		// 영어 패널 구성
		panelEng.setLayout(flowLayoutSubject);
		panelEng.add(labelEng);
		panelEng.add(textFieldEng);
		// 성적 패널 구성
		panelBind.setLayout(gridLayoutBind);
		panelBind.add(panelKor);
		panelBind.add(panelEng);
		panelBind.add(labelTot);
		panelBind.add(labelAvg);
		// button 패널 구성
		panelButton.setLayout(gridLayoutButton);
		button1.setBackground(Color.YELLOW);
		button2.setBackground(Color.YELLOW);
		
		panelButton.add(button1);
		panelButton.add(button2);
		/* BorderLayout 배치 */
		add("Center", panelBind);
		add("South", panelButton);
	}
	// 이벤트 구성
	private void start() {
		// 버튼을 눌렀을 떄의 처리
		button1.addActionListener(this);
		button2.addActionListener(this);
		// 프레임 창의 x버튼의 종료 처리
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
		if (e.getSource() == button1 ) {		// 확인 버튼
			int kor = Integer.parseInt(textFieldKor.getText());		// 문자열로 세팅이 되어 짐.
			int eng = Integer.parseInt(textFieldEng.getText());		// 문자열을 읽어 옮 getText()로.
			int tot = kor + eng;
			double avg = (double) tot / 2 ;
			labelTot.setText(" 총점 : " + tot);
			labelAvg.setText(" 평균 : " + avg);
		} else if (e.getSource() == button2) {	// 취소 버튼
			textFieldKor.setText("");
			textFieldEng.setText("");
			labelTot.setText(" 총점 : ");
			labelAvg.setText(" 평균 : ");
		}
	}
}







