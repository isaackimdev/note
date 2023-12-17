import java.io.IOException;
public class Practice2_1 {
	public static void main(String[] args) throws IOException {		// 예외전가 받음
		Game_1 game = new Game_1(1000);
		while(true) {
			game.inputMenu();
			game.initComputer();
			game.resultGame();
			game.calcMoney();
			game.resultOutput();
			game.inputContinue();
		}
	}
}