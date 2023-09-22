import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] sums = new int[T];
        for (int i = 0; i < T; i++) {
            sums[i] = sc.nextInt();
            sums[i] += sc.nextInt();
        }
        for (int j = 0; j < T; j++) {
            System.out.println(sums[j]);
        }
    }
}
