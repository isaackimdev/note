import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        String[] strs = new String[t];
        for(int i=0; i<t; i++) strs[i] = sc.next();
        for(int i=0; i<t; i++) {
            System.out.println(String.valueOf(strs[i].charAt(0))+String.valueOf(strs[i].charAt(strs[i].length()-1)));
        }
    }
}