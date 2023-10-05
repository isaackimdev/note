import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int alphabetCount = 0;
        String[] croatiaAlphabets =  {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
        
        for(int i = 0; i < s.length(); i++) {
            for(int j = 0; j < croatiaAlphabets.length; j++) {
                int end = i + croatiaAlphabets[j].length();
                end = end < s.length() ? end : s.length();
                if (s.substring(i,  end).trim().equals(croatiaAlphabets[j])) {
                    i += croatiaAlphabets[j].length() - 1;
                    break;
                }
            }
            alphabetCount++;
        }
        System.out.println(alphabetCount);   
    }
}
