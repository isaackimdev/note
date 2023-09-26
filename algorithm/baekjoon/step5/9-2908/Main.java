import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        String newA = "";
        String newB = "";
        for (int i = a.length() - 1; i >= 0; i-- ) newA += a.charAt(i);
        for (int i = b.length() - 1; i >= 0; i-- ) newB += b.charAt(i);
        int ia = Integer.parseInt(newA);
        int ib = Integer.parseInt(newB);
        int res = ia > ib ? ia : ib;
        System.out.println(res);
    }
}