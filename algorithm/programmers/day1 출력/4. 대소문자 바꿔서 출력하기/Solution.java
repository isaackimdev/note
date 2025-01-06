import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();        
        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            
            // 방법 1
            /*if ( c < 97) {
                c += 32;
            } else {
                c -= 32;
            }*/
            
            // 방법 2
            // c = c < 97 ? (char)(c+32) : (char)(c-32);
            
            System.out.print(c < 97 ? (char)(c+32) : (char)(c-32));
        }
        
    }
}