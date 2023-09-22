import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, m, i, j, t;
        n = sc.nextInt();
        m = sc.nextInt();
        int[] b = new int[n];
        for(int s = 0; s < n; s++) b[s] = s+1;
        for ( int s = 0; s < m; s++) {
            i = sc.nextInt() - 1;
            j = sc.nextInt() - 1;
            for ( ; i < j ; i++, j-- ) {
                t=b[i];
                b[i]=b[j];
                b[j]=t;
            }
        }
        for ( int s = 0; s < b.length; s++) System.out.print(b[s]+" ");
    }
}