import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h, m;
        h = sc.nextInt();
        m = sc.nextInt();
        if ( m >= 45 ) {
            System.out.println(h + " " + (m - 45));
        } else if ( m < 45 ) {
            m = (60 + m) - 45;
            h -= 1;
            if (h < 0) {
                h =23;
            }
            System.out.println(h + " " + m);
        }

    }
}