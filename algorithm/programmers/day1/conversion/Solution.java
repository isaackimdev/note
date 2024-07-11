import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();

        for(int i = 0; i<a.length(); i++) {
            char c = a.charAt(i);
            if (65 <= (int) c && c <= 90) { // 대문자
                c += 32;
            } else { // 소문자
                c -= 32;
            }
            System.out.print(c);
        }
    }
}

