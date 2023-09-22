import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] basket = new int[n]; // 바구니 n 개

        int i, j, k;
        for(int count = 0; count < m; count++) { // m 번의 방법
            i = sc.nextInt() - 1; // from
            j = sc.nextInt() - 1; // to
            k = sc.nextInt();

            for ( ; i <= j ; i++ ) {
                basket[i] = k;
            }
        }

        for(int o = 0; o < n; o ++) {
            System.out.print(basket[o] + " ");
        }

    }
}