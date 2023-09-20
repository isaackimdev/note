import java.util.Scanner;

public class Main2 { 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        String[] strs = new String[t];
        for(int i=0; i<t; i++) strs[i] = sc.next();
        // 가독성 up
        for(int i=0; i<t; i++) { 
            char firstChar = strs[i].charAt(0);
            char lastChar = strs[i].charAt(strs[i].length()-1);
            System.out.println(String.valueOf(firstChar) + String.valueOf(lastChar));
        }
    }
}