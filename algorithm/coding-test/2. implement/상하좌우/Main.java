// 상화좌우
// n = 5 -> 행 1~5 열 1~5
// 입력
// 5
// R R R U D D
// 출력
// 3 4

import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        
        int x = 1, y = 1;
        sc.nextLine();
        String str = sc.nextLine();
        
        for(char c : str.toCharArray()) {
            switch (c) {
                case 'R': if (y < n) y += 1;
                    break;
                case 'L' : if (y > 1) y -= 1;
                    break;
                case 'U' : if (x > 1) x -= 1;
                    break;
                case 'D' : if (x < n) x += 1;
                    break;
                default : 
                    break;
            }
        }

        System.out.printf("%d %d\n", x, y);
    }

}