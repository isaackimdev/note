import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x =  sc.nextInt();
        int d = 0;
        int l=1, r=1;
        for(int i=1; i<x; i++) {
            if ( d == 0 ) {         // →
                ++r;
                d=1;
            } else if ( d == 1 ) { // ↙
                ++l;
                --r;
                if(r <= 1 ) d=2; 
            } else if ( d == 2 ) { // ↓
                ++l;
                d=3;
            } else if ( d == 3 ) { // ↗
                --l;
                ++r;
                if(l <= 1) d = 0;
            }
        }
        System.out.println(l+"/"+r);
    }
}