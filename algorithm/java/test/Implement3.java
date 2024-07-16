import java.util.Scanner;

public class Implement3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String yx = sc.nextLine();
        char cy = yx.charAt(0);
        char cx = yx.charAt(1);
        
        Pos[] pos = {
            new Pos(-2, -1), new Pos(-2, 1), 
            new Pos(-1, 2), new Pos(1, 2),
            new Pos(2,1), new Pos(2, -1),
            new Pos(1,-2), new Pos(-1, -2),
        };
        
        // System.out.println((int) cy);
        // System.out.println((int) cx);

        int count = 0;
        for(int i = 0; i<pos.length;i++) {
            int y = (cy - 96) + pos[i].y;
            int x = (cx - 48) + pos[i].x;
            System.out.println(x + " " + y);
            if(y >= 1 && y <= 8 && x >= 1 && x <= 8) count ++;
        }

        System.out.println(count);

        
    }    
}

class Pos {
    int x = 0;
    int y = 0;
    Pos (int x, int y) {
        this.x = x;
        this.y = y;
    }
}
