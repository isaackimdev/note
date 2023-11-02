import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.nextLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int max = a;
        int ex = b + c;
        if (max < b) {
            max = b;
            ex = a + c;
        }
        if (max < c) {
            max = c;
            ex = a + b;
        }
        if (max >= ex) {
            max -= (max - ex);
            max --;
        }
        System.out.println(max+ex);
    }
}