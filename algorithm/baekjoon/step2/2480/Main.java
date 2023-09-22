import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a,b,c,bonus, max;
        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();

        if ( a == b && b == c ) {
            bonus = 10000 + a*1000;
        } else if ( 
            (a == b && b != c) ||
            (a == c && a != b) ||
            (b == c && a != b)
         ) {
            bonus = 1000;
            if ( a == b || a == c) bonus += (a*100);
            else bonus += (b*100);
         } else {
            max = a;
            if ( max < b) { 
                max = b;
            } 
            if ( max < c ) {
                max = c;
            }
            bonus = max * 100;
        }
        System.out.println(bonus);
    }
}