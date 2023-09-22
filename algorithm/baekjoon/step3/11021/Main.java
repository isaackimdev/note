import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int a, b;

        for (int i = 1; i<=t; i++) {
            a = sc.nextInt();
            b = sc.nextInt();
            System.out.println("Case #"+i+": "+ (a+b));
        }
    }
}