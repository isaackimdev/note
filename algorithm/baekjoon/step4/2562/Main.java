import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] a = new int[9];
        int max = 0;
        int maxIndex = 1;
        for (int i = 0; i < 9; i++) {
            a[i] = sc.nextInt();
        }
        max = a[0];

        for (int i = 0; i <9; i++) {
            if (max < a[i]) {
                max = a[i];
                maxIndex = i + 1;
            }
        }
        System.out.println(max);
        System.out.println(maxIndex);
    }
}