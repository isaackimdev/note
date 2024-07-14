import java.util.Arrays;
import java.util.Scanner;

public class Greedy3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();

        int[][] sheet = new int[n][m];
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sheet[i][j] = sc.nextInt();
            }
            sc.nextLine();
        }

        int max = 0;
        for(int[] row : sheet) {
            Arrays.sort(row);
            if (max < row[0]) {
                max = row[0];
            }
            System.out.println(Arrays.toString(row));
        }
        System.out.println(max);
    }
}
