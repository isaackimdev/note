import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int price = sc.nextInt();
        int ret = 1000 - price;
        int count = 0;
        count += ret / 500;
        ret %= 500;
        count += ret / 100;
        ret %= 100;
        count += ret / 50;
        ret %= 50;
        count += ret / 10;
        ret %= 10;
        count += ret / 5;
        ret %= 5;
        count += ret / 1;
        ret %= 1;
        System.out.println(count);
    }
}
