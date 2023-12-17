import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.border.Border;

public class CalculatorForm extends Frame implements ActionListener{
	// 선언
	TextField textField = new TextField("0");	// default 값으로 0
	Panel panelNum = new Panel();
	Button[] buttonsNum;	// 입력할 버튼 
	Button buttonResult;
	String[] str_num = {"7","8","9","/",
						"4","5","6","*",
						"1","2","3","-",
						"0","+/-",".","+",
	};
	String input="";			// 입력값 저장
	boolean positive = true;	// 음수/양수 판단용
	double num1, num2, result;	// 계산할 입력 값
	String op;					// 연산자 저장
	// 초기화 : 생성자
	public CalculatorForm() {
		// Frame 설정
		setTitle("계산기");
		setSize(250, 200);
		setLocation(300, 300);
		
		init();
		start();
		
		setResizable(false);	// 화면크기 고정
		setVisible(true);		// 화면을 보이기 
	}
	// 화면구성
	private void init() {
		// frame layout 설정
		setLayout(new BorderLayout());
		// panelNum 설정
		panelNum.setLayout(new GridLayout(4, 4, 4, 4));
		panelNum.setBackground(Color.LIGHT_GRAY);
		// panelNum에 숫자 버튼 추가하기
		buttonsNum = new Button[str_num.length];
		
		for(int i = 0 ; i<str_num.length ; i++ ) {
			buttonsNum[i] = new Button(str_num[i]);	// 글자 하나씩 버튼을 생성과 함께 넣는다.
			buttonsNum[i].setForeground(Color.BLUE);// String배열,문자열을 버튼[] 배열에 집어 넣음
			buttonsNum[i].addActionListener(this);	// 이벤트 설정
			panelNum.add(buttonsNum[i]);
		}
		// frame에 위치 배정
		textField.setEditable(false);	// 키보드값 입력 금지
		buttonResult = new Button("=");
		buttonResult.setForeground(Color.BLUE);	// 글자색 : 파란색 // foreground 표면 색, 글자색을 변경세팅해줌
		add("North",textField);
		add("Center",panelNum);
		add("South", buttonResult);
	}
	// 이벤트 설정
	private void start() {
		// " = " 버튼을 눌렀을 때의 설정
		buttonResult.addActionListener(this);
		
		// 프레임 창의x버튼의 종료 처리
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
		if (e.getSource()==buttonsNum[0]) {	// 7
			input += "7";
		} else if(e.getSource()==buttonsNum[1]) {	// 8
			input += "8";
		} else if(e.getSource()==buttonsNum[2]) {	// 9
			input += "9";
		} else if(e.getSource()==buttonsNum[3]) {	// /
			num1 = Double.parseDouble(input);
			op = "/";
			input ="";
		} else if(e.getSource()==buttonsNum[4]) {	// 4
			input += "4";
		} else if(e.getSource()==buttonsNum[5]) {	// 5
			input += "5";
		} else if(e.getSource()==buttonsNum[6]) {	// 6
			input += "6";
		} else if(e.getSource()==buttonsNum[7]) {	// *
			num1 = Double.parseDouble(input);
			op = "*";
			input ="";
		} else if(e.getSource()==buttonsNum[8]) {	// 1
			input += "1";
		} else if(e.getSource()==buttonsNum[9]) {	// 2
			input += "2";
		} else if(e.getSource()==buttonsNum[10]) {	// 3
			input += "3";
		} else if(e.getSource()==buttonsNum[11]) {	// -
			num1 = Double.parseDouble(input);
			op = "-";
			input ="";
		} else if(e.getSource()==buttonsNum[12]) {	// 0
			input += "0";
		} else if(e.getSource()==buttonsNum[13]) {	// +/-
			if(positive) {	// true이면; 양수이면 음수로 전환
				positive = false;
				input = "-" +input;
			} else {	// false이면; 음수이면 양수로 전환
				positive = true;
				input = input.substring(1);		// substring 잘라내기, 잘라내기로 음수를 잘라버림.
			}
		} else if(e.getSource()==buttonsNum[14]) {	// .
			input += ".";
		} else if(e.getSource()==buttonsNum[15]) {	// +
			num1 = Double.parseDouble(input);
			op = "+";
			input ="";
		} else if(e.getSource()== buttonResult) {	// =
			num2 = Double.parseDouble(input);
			switch (op) {
			case "+" : result = num1 + num2;
				break;
			case "-" : result = num1 - num2;
				break;
			case "*" : result = num1 * num2;
				break;
			case "/" : if(num2 != 0) result = num1 / num2;
						else result = 0;
				break;
			}
			// 텍스트 필드로 출력을 내보낼 것 ( 연산결과를 통하여 )
			textField.setText(String.valueOf(result));	// 실수 값을 문자열로 바꿔라 String.valueOf
			input = "";			// input 초기화
			num1 = num2 = 0;	// num1, num2 초기화
			positive = true;	// positive 초기화
			return;			// return 을 통하여 메소드를 종료시킴
		
		}
		
		textField.setText(input);	// 입력값 출력
	}

}
// 큰 기능을 먼저 구현한 후에 디테일하게 기능 구현할 것.