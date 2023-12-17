import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JList;

class Swing14 extends JFrame {
	// 선언
	Container container = getContentPane();
	String[] str = {"AAA","BBB","CCC","DDD","EEE"};
	JList<String> list = new JList<>(str);
	
	// 초기화 : 생성자 
	public Swing14() {
		setTitle("swing");
		setSize(300,200);
		setLocation(300,300);
		init();
		start();
		setVisible(true);
		
		showChange();
	}
	
	// 화면 구성
	private void init() {
		container.setLayout(new FlowLayout());
		list.addSelectionInterval(1, 3);
		container.add(list);	// 컨테이너에 리스트를 추가
		
	}
	// 이벤트 설정
	private void start() {}
	// 이벤트 처리
	private void showChange() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		list.clearSelection();	// 선택된 영역을 해제한다.
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		String[] str1 = {"aaa","bbb","ccc","ddd","eee"};
		list.setListData(str1);
		list.setSelectionBackground(Color.red);
		list.setSelectionForeground(Color.YELLOW);
		list.setSelectedIndex(3);
		
	}
}
public class Exam14 {

	public static void main(String[] args) {
		Swing14 swing14 = new Swing14();
	}

}
