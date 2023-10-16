import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int e = sc.nextInt();
        int r = 1;
        int i = 0;
        while(e > r ) {
            i++;
            r += (i*6);
        }
        System.out.println(i+1);
    }
}