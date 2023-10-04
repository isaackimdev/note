import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int maxCount = 0;
        int maxIndex = 0;
        char res = '?';
        int[] cnts = new int['Z'+1]; // 98
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int idx = c <= 'Z' ? c : c - ('z' - 'Z');
            cnts[idx] ++;
        }

        // check Max
        for(int i = 'A'; i <= 'Z'; i++) {
            if (maxCount < cnts[i]) {
                maxCount = cnts[i];
                maxIndex = i;
                res = (char) i;
            }
        }

        for(int i = 'A'; i <= 'Z'; i++) {
            if (i == maxIndex) continue;
            else if (maxCount == cnts[i]) {
                res = '?';
                break;
            }
        }
        
        System.out.println(res);

    }
}
