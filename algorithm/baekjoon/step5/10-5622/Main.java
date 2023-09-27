import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        char[][] dialChars = new char[][] {
            {'A','B','C',' '},
            {'D','E','F',' '},
            {'G','H','I',' '},
            {'J','K','L',' '},
            {'M','N','O',' '},
            {'P','Q','R','S'},
            {'T','U','V',' '},
            {'W','X','Y','Z'}
        }; // +3
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        
        int time = 0;

        for ( int i = 0; i < s.length(); i++ ) {
            char c = s.charAt(i);
            boolean isMatch = false;
            for ( int j = 0; j < dialChars.length; j++) {
                for ( int k = 0; k<4; k++) {
                    if (c == dialChars[j][k]) {
                        time += j + 3;
                        isMatch = true;
                        break;
                    }
                    if (isMatch) break;
                }
            }
        }
        System.out.println(time);
    }
}