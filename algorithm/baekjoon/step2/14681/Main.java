import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x, y;
        x = sc.nextInt();
        y = sc.nextInt();

        if (x > 0 && y > 0) qprt(1);
        else if (x < 0 && y > 0) qprt(2);
        else if (x < 0 && y < 0) qprt(3);
        else if (x > 0 && y < 0) qprt(4);
    }

    static void qprt(int q) {
        System.out.println(q);
    }
}