import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, m;
        n = sc.nextInt();
        m = sc.nextInt();

        int[] a = new int[n];
        for (int x = 0; x < n ; x++ ) a[x] = x+1;

        int i, j, t;
        for (int x = 0; x < m ; x++ ) {
            i = sc.nextInt();
            j = sc.nextInt();
            
            t = a[i-1];
            a[i-1] = a[j-1];
            a[j-1] = t;
        }

        for (int x = 0; x < n; x++) System.out.print(a[x] + " ");
    }
}