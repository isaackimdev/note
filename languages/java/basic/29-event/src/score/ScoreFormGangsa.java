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

// 화면 꾸미기 + 이벤트 처리
public class ScoreFormGangsa extends Frame implements ActionListener {	// 마우스 클릭 및 키보드 입력을 위해 액션 상속
	// 선언
	Button btnInput, btnOutput, btnHakSearch, btnNameSearch, btnWriteFile, btnReadFile;
	Label labelHak, labelName, labelKor, labelEng, labelMat;
	TextField textFieldHak, textFieldName, textFieldKor, textFieldEng, textFieldMat;
	TextArea textArea;
	BorderLayout borderLayout;
	GridLayout gridLayoutBind, gridLayoutButton, gridLayoutCenter;
	FlowLayout flowLayout;
	Panel panelButton, panelBind, panelCenter;
	Panel panelHak, panelName, panelKor, panelEng, panelMat;
	
	ScoreImpl scoreImpl = new ScoreImpl();	// 기능 선언 
	// 생성자 : 초기화
	public ScoreFormGangsa(){
		btnInput = new Button("입력");
		btnOutput = new Button("출력");
		btnHakSearch = new Button("학번검색");
		btnNameSearch = new Button("이름 검색");
		btnWriteFile = new Button("저장");
		btnReadFile = new Button("불러오기");
		
		labelHak = new Label("학번");
		labelName = new Label("이름");
		labelKor = new Label("국어");
		labelEng = new Label("영어");
		labelMat = new Label("수학");

		textFieldHak = new TextField(15);
		textFieldName = new TextField(15);
		textFieldKor = new TextField(15);
		textFieldEng = new TextField(15);
		textFieldMat = new TextField(15);
		
		textArea = new TextArea();
		textArea.setSize(500, 230);
		
		borderLayout = new BorderLayout();
		gridLayoutBind = new GridLayout(5, 1);		// 5행 1열
		gridLayoutButton = new GridLayout(1, 6);	// 1행 6열
		gridLayoutCenter = new GridLayout(1, 2);	// 1행 2열
		flowLayout = new FlowLayout(FlowLayout.LEFT);	// 왼쪽 정렬
		
		panelHak = new Panel();
		panelName = new Panel();
		panelKor = new Panel();
		panelEng = new Panel();
		panelMat = new Panel();
		panelBind = new Panel();
		panelButton = new Panel();
		panelCenter = new Panel();
		
		setTitle("성적관리");
		setSize(650,250);
		setLocation(300,300);
		
		init();
		start();
		
		setVisible(true);
		
	}
	// 화면 꾸미기 init
	private void init() {
		// frame layout 설정
		setLayout(borderLayout);
		// 학번
		panelHak.setLayout(flowLayout);
		panelHak.add(labelHak);
		panelHak.add(textFieldHak);
		// 이름
		panelName.setLayout(flowLayout);
		panelName.add(labelName);
		panelName.add(textFieldName);
		// 국어
		panelKor.setLayout(flowLayout);
		panelKor.add(labelKor);
		panelKor.add(textFieldKor);
		// 영어
		panelEng.setLayout(flowLayout);
		panelEng.add(labelEng);
		panelEng.add(textFieldEng);
		// 수학
		panelMat.setLayout(flowLayout);
		panelMat.add(labelMat);
		panelMat.add(textFieldMat);
		// 학번, 이름, 국어, 영어, 수학 >> 묶기
		panelBind.setLayout(gridLayoutBind);
		panelBind.add(panelHak);
		panelBind.add(panelName);
		panelBind.add(panelKor);
		panelBind.add(panelEng);
		panelBind.add(panelMat);
		// panelBind와 textArea 묶기
		panelCenter.setLayout(new BorderLayout());
		panelCenter.add("West", panelBind);
		panelCenter.add("Center",textArea);
		// Button bind
		panelButton.setLayout(gridLayoutButton);
		btnInput.setBackground(Color.YELLOW);
		btnOutput.setBackground(Color.YELLOW);
		btnHakSearch.setBackground(Color.YELLOW);
		btnNameSearch.setBackground(Color.YELLOW);
		btnWriteFile.setBackground(Color.YELLOW);
		btnReadFile.setBackground(Color.YELLOW);
		
		panelButton.add(btnInput);
		panelButton.add(btnOutput);
		panelButton.add(btnHakSearch);
		panelButton.add(btnNameSearch);
		panelButton.add(btnWriteFile);
		panelButton.add(btnReadFile);		
		
		// frame에 결합하기
		add("Center" , panelCenter);
		add("South", panelButton);
	}
	// 이벤트 설정
	private void start() {
		btnInput.addActionListener(this);
		btnOutput.addActionListener(this);
		btnHakSearch.addActionListener(this);
		btnNameSearch.addActionListener(this);
		btnWriteFile.addActionListener(this);
		btnReadFile.addActionListener(this);
		// x표 누루면 닫기.
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
		if(e.getSource() == btnInput) {
			String str_hak = textFieldHak.getText();
			String str_name = textFieldName.getText();
			String str_kor = textFieldKor.getText();
			String str_eng = textFieldEng.getText();
			String str_mat = textFieldMat.getText();
			
			// 입력된 값을 검사해줘야 함.
			if(str_kor.equals("")|| str_eng.equals("") || str_mat.equals("")) {
				textArea.setText("국어, 영어, 수학 점수를 입력해주세요");
				return;
			}
			
			int kor = Integer.parseInt(str_kor);
			int eng = Integer.parseInt(str_eng);
			int mat = Integer.parseInt(str_mat);
			int tot = kor + eng + mat;
			double avg = (double) tot / 3;
			
			// 빈즈 생성
			ScoreVO scoreVO = new ScoreVO();
			scoreVO.setHak(str_hak);
			scoreVO.setName(str_name);
			scoreVO.setKor(kor);
			scoreVO.setEng(eng);
			scoreVO.setMat(mat);
			scoreVO.setTot(tot);
			scoreVO.setAvg(avg);
			
			// 기능 생성
			scoreImpl.input(scoreVO);
			
			textFieldHak.setText("");
			textFieldName.setText("");
			textFieldKor.setText("");
			textFieldEng.setText("");
			textFieldMat.setText("");
			
			
		} else if (e.getSource() == btnOutput) {
			textArea.setText(scoreImpl.print());
		} else if (e.getSource() == btnHakSearch) {
			String hak = textFieldHak.getText();
			textArea.setText(scoreImpl.searchHak(hak));
		} else if (e.getSource() == btnNameSearch) {
			String name = textFieldName.getText();
			textArea.setText(scoreImpl.searchName(name));
		} else if (e.getSource() == btnWriteFile) {
			textArea.setText(scoreImpl.saveFile());
		} else if (e.getSource() == btnReadFile) {
			textArea.setText(scoreImpl.readFile());
		} 
	}
}
