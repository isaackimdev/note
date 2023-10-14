import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ds = 2;
        for(int i=0;i<n;i++) {
            ds += (int) Math.pow(2, i);
        }
        System.out.println(ds*ds);
    }
}