import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int[] alphaSequences = new int[26];
        int j;

        // set default value : -1
        for (int i = 0; i<alphaSequences.length; i++) alphaSequences[i] = -1;

        for (int i = 0; i<s.length(); i++) {
            j = 0;
            for(char a = 'a'; a <= 'z'; a++) {
                
                if (s.charAt(i) == a && alphaSequences[a-97] == -1) {
                    alphaSequences[a-97] = i;
                    break;
                }
                j++;
            }
        }

        // output
        for (int i = 0; i<alphaSequences.length; i++) System.out.print(alphaSequences[i] + " ");       
    }
}