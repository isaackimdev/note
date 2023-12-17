import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;

public class Exam2 {

	public static void main(String[] args) {
		Frame f = new Frame();
		f.setSize(300, 200);
		f.setTitle("기본화면");
		
		// 화면 분할에 Layout을 사용하지 않음
		f.setLayout(null);
		Button button = new Button("확인");
		// 버튼의 바탕색 설정
		button.setBackground(Color.YELLOW);	// YELLO static 상수로 만들어 져 있음.
		// 버튼의 위치와 크기 지정
		// button.setBounds(int x, int y, int width, int height);
		button.setBounds(100, 100, 80, 30);
		
		// frame 안에 들어가는 것은 컴퍼넌트라고 함. 컴퍼넌트 추가
		f.add(button);
		f.setVisible(true);
		
	}

}
