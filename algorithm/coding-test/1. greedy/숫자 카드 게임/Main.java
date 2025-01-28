/*

입력
3 3
4 1 4
2 2 2

출력
2

입력2
2 4
7 3 1 8
3 3 3 4

출력2
3

 */
import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arrMin = new int[n];
       
        int max = Integer.MIN_VALUE;
        int min = 0;
        for(int i = 0; i < n; i++) {
            min = Integer.MAX_VALUE;
            for(int j = 0; j < m; j++) {
                int input = sc.nextInt();
                if (min > input) min = input;
            }
            if (min < max) min = max;
        }
       
        System.out.println(min);
    }
}