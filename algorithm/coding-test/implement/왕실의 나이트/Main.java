// 행 1~8, 열 a~h - 8x8
// 입력 : a1
// 출력 : 2
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inputPostion = sc.next();
        
        Pos[] pos = {
            new Pos(-2, -1), new Pos(-2, 1),
            new Pos(-1, 2), new Pos(1, 2),
            new Pos(2, -1), new Pos(2, 1),
            new Pos(-1, -2), new Pos(1,-2)
        };

        char cx = inputPostion.charAt(1);
        char cy = inputPostion.charAt(0);
        
        int count = 0;
        for(int i = 0; i < pos.length; i++) {
            int x = (cx - 48) + pos[i].x;
            int y = (cy - 96) + pos[i].y;
            if ( x >= 1 && x < 9 && y >= 1 && y < 9) count += 1;
        }

        System.out.println(count);
    }
}

class Pos {
    int x = 0;
    int y = 0;
    Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }
}