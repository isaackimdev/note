import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class CalcMan extends Frame implements ActionListener{
	Button[] button = new Button[17];	// 버튼 17개
	TextField textField;	// 텍스트 필드
	TextArea textArea;	// 텍스트 필드
	BorderLayout borderLayout;
	GridLayout gridLayoutText, gridLayoutEqual, gridLayoutCalc, gridLayoutCalcCol;
	Panel panelTextarea, panelEqual, panelCenter;
	Panel panelCalcLine1, panelCalcLine2, panelCalcLine3, panelCalcLine4; 
	
	public CalcMan () {
		
//		for(int i=0; i<10; i++) {	//0~9까지의 버튼 생성
//			button[0] = new Button(""+i);			
//		}
		button[0] = new Button("0");
		button[1] = new Button("1");
		button[2] = new Button("2");
		button[3] = new Button("3");
		button[4] = new Button("4");
		button[5] = new Button("5");
		button[6] = new Button("6");
		button[7] = new Button("7");
		button[8] = new Button("8");
		button[9] = new Button("9");

		button[10] = new Button(""+"+/-");
		button[11] = new Button(""+".");
		button[12] = new Button(""+"/");
		button[13] = new Button(""+"*");
		button[14] = new Button(""+"-");
		button[15] = new Button(""+"+");
		button[16] = new Button(""+"=");	// 0번째부터 시작하니까 16배열 버튼까지 생성
		
		textField = new TextField();
		textArea = new TextArea();
		
		borderLayout = new BorderLayout();
		
		gridLayoutText = new GridLayout(1, 1);
		gridLayoutEqual = new GridLayout(1, 1);
		gridLayoutCalc = new GridLayout(4,1,     3,3);		// 4행 1열	/ 세부1차
		gridLayoutCalcCol = new GridLayout(1, 4,     3,3);	// 1행 4열	/ 세부 2차
		
		panelTextarea = new Panel();
		panelEqual = new Panel();
		panelCenter = new Panel();
		
		panelCalcLine1 = new Panel();
		panelCalcLine2 = new Panel();
		panelCalcLine3 = new Panel();
		panelCalcLine4 = new Panel();
		
		
		setTitle("계산기");
		setSize(300,300);
		setLocation(600, 250);
		
		init();		// 화면
		start();	// 이벤트 설정
		
		setResizable(false);	// 화면크기 고정
		setVisible(true);
	}
	
	
	private void init(){
		// Frame Layout 설정하기
		setLayout(borderLayout);
		// textArea 위치 설정하기
		panelTextarea.setLayout(gridLayoutText);	// 북쪽으로 놓기
		panelTextarea.add(textField);	// 텍스트 필드 저장
		// = 버튼 아래쪽에 위치 설정하기
		panelEqual.setLayout(gridLayoutEqual); // 남쪽으로 놓기
		panelEqual.add(button[16]);
		
		/** 세부버튼 만들어주기 */
		// Calc 버튼 배치해주기  [ 라인 1 ] 
		panelCalcLine1.setLayout(gridLayoutCalc);	// 4행1열
		panelCalcLine1.add(button[7]);
		panelCalcLine1.add(button[4]);
		panelCalcLine1.add(button[1]);
		panelCalcLine1.add(button[0]);
		// Calc 버튼 배치해주기  [ 라인 2 ] 
		panelCalcLine2.setLayout(gridLayoutCalc);	// 4행1열
		panelCalcLine2.add(button[8]);
		panelCalcLine2.add(button[5]);
		panelCalcLine2.add(button[2]);
		panelCalcLine2.add(button[10]);
		// Calc 버튼 배치해주기  [ 라인 3 ] 
		panelCalcLine3.setLayout(gridLayoutCalc);	// 4행1열
		panelCalcLine3.add(button[9]);
		panelCalcLine3.add(button[6]);
		panelCalcLine3.add(button[3]);
		panelCalcLine3.add(button[11]);
		// Calc 버튼 배치해주기  [ 라인 4 ] 
		panelCalcLine4.setLayout(gridLayoutCalc);	// 4행1열
		panelCalcLine4.add(button[12]);
		panelCalcLine4.add(button[13]);
		panelCalcLine4.add(button[14]);
		panelCalcLine4.add(button[15]);
		// Calc 패널 합치기
		panelCenter.setLayout(gridLayoutCalcCol);
		panelCenter.add(panelCalcLine1);
		panelCenter.add(panelCalcLine2);
		panelCenter.add(panelCalcLine3);
		panelCenter.add(panelCalcLine4);
		
		// frame에 결합하기
		add("North", panelTextarea);
		add("South", panelEqual);
		add("Center", panelCenter);
		
		
	}
	// 이벤트 설정
	private void start() {
		for(int i = 0 ; i < button.length ; i++) {
			button[i].addActionListener(this);
		}
		
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
		
	}
	
	
}


public class Exam8 {
	public static void main(String[] args) {
//		CalcMan calcMan = new CalcMan();
		CalculatorForm ccForm = new CalculatorForm();
	}
}
