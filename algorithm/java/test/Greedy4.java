import java.util.Scanner;

public class Greedy4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        sc.nextLine();

        int count = 0;
        while(true) {
            if (n == 1) break;
            if (n % k == 0 ) {
                n /= k;
                count ++;
            } else {
                n --;
                count ++;
            }
        }
        System.out.println(count);
    }
}
