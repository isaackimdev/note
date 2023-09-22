import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int max, min;

        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        max = a[0];
        min = a[0];

        for(int i = 0; i < n; i++) {
            max = max < a[i] ? a[i] : max;
            min = min > a[i] ? a[i] : min;
        }
        System.out.println(min + " " + max);
    }
}