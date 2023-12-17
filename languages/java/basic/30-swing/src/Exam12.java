import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JComboBox;
import javax.swing.JFrame;

class Swing12 extends JFrame {
	// 선언
	Container container = getContentPane();
	String[] str = {"AAA","BBB","CCC","DDD","EEE"};
	JComboBox<String> comboBox = new JComboBox<>(str);
	
	// 초기화 : 생성자 
	public Swing12() {
		setTitle("swing");
		setSize(300,200);
		setLocation(300,300);
		init();
		start();
		setVisible(true);
		
		showPopup();
	}
	private void showPopup() {
		System.out.println("얻어온 객체 = " + comboBox.getItemAt(3));
		System.out.println("포함된 객체 개수 = " + comboBox.getItemCount());
		System.out.println("현재 선택된 객체 = " + comboBox.getSelectedItem());
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		comboBox.setSelectedIndex(1);	// 두번째 객체 선택
		comboBox.showPopup();			// 하위 팝업을 열어 준다.
		container.repaint();			// 화면 새로 고쳐서 보여주기
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		comboBox.hidePopup();
		container.repaint();
		
	}
	// 화면 구성
	private void init() {
		// 컨테이너 레이아웃 설정
		container.setLayout(new FlowLayout());
		comboBox.addItem("FFF");
		comboBox.setEditable(true);	// 콤보박스의 내용을 수정하게 만들어 준다.
		comboBox.setMaximumRowCount(3);	// 스크롤되지 않고 보여줄 수 있는 행의 최대 개수 설정
		container.add(comboBox);
	}
	// 이벤트 설정
	private void start() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	// 이벤트 처리
}

public class Exam12 {

	public static void main(String[] args) {
		Swing12 swing12 = new Swing12();
	}

}
