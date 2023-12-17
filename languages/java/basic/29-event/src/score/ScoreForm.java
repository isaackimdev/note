package score;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
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

public class ScoreForm extends Frame implements ActionListener {
	Button bt1, bt2, bt3, bt4, bt5, bt6;
	Label laHak, laName, laKor, laEng, laMath;
	TextField txFHak, txFName, txFKor, txFEng, txFMath;
	TextArea textArea;
	FlowLayout flowLayout;
	BorderLayout borderLayout;
	GridLayout gridLayout1, gridLayout2, gridBtn, gridLayout3;
	Panel paHak, paName, paKor, paEng, paMath, paBt, paLeft, paRig, paCen;
	
	// 생성자
	public ScoreForm() {
		bt1 = new Button("입력");
		bt2 = new Button("출력");
		bt3 = new Button("학번검색");
		bt4 = new Button("이름검색");
		bt5 = new Button("파일저장");
		bt6 = new Button("파일읽기");
		borderLayout = new BorderLayout();
		laHak = new Label("학번");
		laName = new Label("이름");
		laKor = new Label("국어");
		laEng = new Label("영어");
		laMath = new Label("수학");
		txFHak = new TextField(17);
		txFName = new TextField(17);
		txFKor  = new TextField(17);
		txFEng  = new TextField(17);
		txFMath  = new TextField(17);
		textArea = new TextArea();	// 텍스트 에어리아
		flowLayout = new FlowLayout(FlowLayout.LEFT);	// 왼쪽정렬
		gridLayout1 = new GridLayout(1, 2);	// 1행 2열
		gridLayout2 = new GridLayout(5, 2);	// 5행 1열
		gridLayout3 = new GridLayout(1,1);	// 1행 1열
		gridBtn = new GridLayout(1, 6);	// 1행 6열
		paHak = new Panel();
		paName = new Panel();
		paKor = new Panel();
		paEng = new Panel();
		paMath = new Panel();
		paLeft = new Panel();
		paRig = new Panel();
		paCen = new Panel();
		paBt = new Panel();
		// 프레임 설정
		setSize(450, 300);
		setTitle("성적관리");
		setLocation(300, 300);
		
		initaa();
		start();
		
		setVisible(true);
		
	}
	// 화면 구성
	private void initaa() {
		//frame layout 설정
		setLayout(borderLayout);
		// 학번 패널 구성
		paHak.setLayout(flowLayout);
		paHak.add(laHak);
		paHak.add(txFHak);
		// 이름 패널 구성
		paName.setLayout(flowLayout);
		paName.add(laName);
		paName.add(txFName);
		// 국어패널 구성
		paKor.setLayout(flowLayout);
		paKor.add(laKor);
		paKor.add(txFKor);
		// 영어 패널 구성
		paEng.setLayout(flowLayout);
		paEng.add(laEng);
		paEng.add(txFEng);
		// 수학 패널 구성
		paMath.setLayout(flowLayout);
		paMath.add(laMath);
		paMath.add(txFMath);
		// 왼쪽 입력 패널 구성
		paLeft.setLayout(gridLayout2);	// 5행 2열
		paLeft.add(paHak);
		paLeft.add(paName);
		paLeft.add(paKor);
		paLeft.add(paEng);
		paLeft.add(paMath);
		// 버튼 패널 구성
		paBt.setLayout(gridBtn);	// 1행 6열
		// 버튼 꾸미기
		bt1.setBackground(Color.YELLOW);
		bt2.setBackground(Color.YELLOW);
		bt3.setBackground(Color.YELLOW);
		bt4.setBackground(Color.YELLOW);
		bt5.setBackground(Color.YELLOW);
		bt6.setBackground(Color.YELLOW);
		// 패널버튼에 버튼 넣기,
		paBt.add(bt1);
		paBt.add(bt2);
		paBt.add(bt3);
		paBt.add(bt4);
		paBt.add(bt5);
		paBt.add(bt6);
		
		// area패널 오른쪽으로 
		paRig.setLayout(gridLayout3);
		/* BoderLayout 배치 */
		add("Center", paLeft);	
		add("South", paBt); // 버튼을 아래에 두기
		
		
	}
	// 이벤트 처리
	private void start() {
		bt1.addActionListener(this);
		bt2.addActionListener(this);
		bt3.addActionListener(this);
		bt4.addActionListener(this);
		bt5.addActionListener(this);
		bt6.addActionListener(this);
		
		// 프레임 창의 x버튼의 종료 처리
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
				super.windowClosing(e);
			}
		});
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	
}
