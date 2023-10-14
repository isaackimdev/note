import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++){
            int c = sc.nextInt();
            int q=0,d=0,n=0,p=0;
            if(c>24){
                q = c / 25;
                c = c % 25;
            }
            d = c / 10;
            c = c % 10;

            n = c / 5;
            c = c % 5;

            p = c / 1;
            c = c % 1;

            System.out.printf("%d %d %d %d\n", q,d,n,p);
        }
    }
}