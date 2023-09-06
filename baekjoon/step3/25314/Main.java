import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String res = "";
        int count = n / 4;
        for ( int i = 0; i < count; i++) {
            res += "long ";
        }
        System.out.println(res + "int");
    }
}