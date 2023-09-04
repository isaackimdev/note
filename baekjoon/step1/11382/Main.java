import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a,b,c; // int의 합이 long형 크기일 수 있어서 long으로 해야 오류가 안남.
        a = sc.nextLong();
        b = sc.nextLong();
        c = sc.nextLong();
        System.out.println(a+b+c);
    }
}