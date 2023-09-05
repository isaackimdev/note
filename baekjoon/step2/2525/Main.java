import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h, m, runtime, hourAddTime;
        h = sc.nextInt();
        m = sc.nextInt();
        runtime = sc.nextInt();
        
        hourAddTime = runtime / 60;
        h += hourAddTime;
        m += runtime % 60;

        if (m >= 60) {
            h += 1;
            m -= 60;
        }
        if (h >= 24) {
            h -= 24;
        }
        
        System.out.println(h + " " + m);
    }
}