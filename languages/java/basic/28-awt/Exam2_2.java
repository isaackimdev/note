import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;

public class Exam2_2 {
	public static void main(String[] args) {
		Frame f = new Frame();
		f.setSize(700, 700);
		f.setTitle("Java chipchip");
		
		// 화면 분할에 Layout을 사용하지 않음
		f.setLayout(null);
		Button button = new Button("로라리리리리");
		// 버튼의 바탕색 설정
		button.setBackground(Color.GRAY);	// BLACK 은 static 상수로 만들어 져 있음.
		// 버튼의 위치와 크기 지정
		// button.setBounts(int x, inty, int width, int heigh);
		button.setBounds(100,100,100, 100);
		
		f.add(button);
		f.setVisible(true);
	}
}
