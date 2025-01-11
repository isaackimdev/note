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