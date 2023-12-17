import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

import helper.FileHelper;

class Swing10 extends JFrame implements ActionListener {
	// 선언
	Container container = getContentPane();
	JColorChooser jColorChooser = new JColorChooser();
	JFileChooser jFileChooser = new JFileChooser("D://");
	JButton jButtonColorSelect = new JButton("색 선택");
	JButton jButtonFileSelect = new JButton("파일 선택");
	// 초기화 : 생성자
	public Swing10() {
		setTitle("swing");
		setSize(300,200);
		setLocation(300, 300);
		init();
		start();
		setVisible(true);
	}
	// 화면구성
	private void init() {
		container.setLayout(new FlowLayout());
		container.add(jButtonColorSelect);
		container.add(jButtonFileSelect);
	}
	// JColorChooser 구성/setting
	private void colorChooser() {
		Color color = jColorChooser.showDialog(this, "나의 색상선택", Color.green);
		System.out.println("선택한 색상 = " + color.toString());	// toString() 은 생략가능
		jColorChooser.setColor(color);	// 기본 색상 지정해 두기
		System.out.println("다시 얻어오기 = " + jColorChooser.getColor());
		jButtonColorSelect.setBackground(color);
		
	}
	// JFileChooser 구성/setting
	private void fileChooser() {
		// 다이얼로그 타이틀 글자 바꾸기
		jFileChooser.setDialogTitle("불러오기");
		// 다중 선택 가능하게 만들기
		jFileChooser.setMultiSelectionEnabled(true);
		// 다이얼로그 버튼 글자 바꾸기
		jFileChooser.showDialog(this, "열기");
		File file = jFileChooser.getSelectedFile();
		System.out.println("파일명 : " + file);
		// Filehelper.java 띄우기
		String str = FileHelper.getInstance().readString(file.toString(),"MS949");
		System.out.println("선택파일 내용 : " + str );
		
	}
	// 이벤트 설정
	private void start() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		jButtonColorSelect.addActionListener(this);
		jButtonFileSelect.addActionListener(this);
	}
	// 이벤트 처리
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == jButtonColorSelect) {
			colorChooser();	// 색 선택시, 색 선택 기능(함수)로 이동 
		} else if (e.getSource() == jButtonFileSelect) {
			fileChooser();	// 파일 선택시, 파일 선택 기능(함수)로 이동
		}
	}
	
}
public class Exam10 {

	public static void main(String[] args) {
		Swing10 swing10 = new Swing10();
	}

}
