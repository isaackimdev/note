import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        StringBuffer sb = new StringBuffer(s);
        int r = 0;
        if(s.equals(sb.reverse().toString())) r = 1;
        System.out.println(r);
    }    
}
