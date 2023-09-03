import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v1, v2;
        v1 = sc.nextInt();
        v2 = sc.nextInt();
        int a,b,c;
        a = v2 / 100;
        b = (v2 % 100) / 10;
        c = ((v2 % 100) % 10);

        System.out.println(v1 * c);
        System.out.println(v1 * b);
        System.out.println(v1 * a);
        System.out.println(v1 * v2);
    }
}