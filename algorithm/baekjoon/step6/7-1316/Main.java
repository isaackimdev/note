import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int grWordCnt=0;
        int[] wordCnt = new int['z'+1];
        int[] wordCntZero = wordCnt.clone();
        for (int i=0;i<n;i++){
            wordCnt = wordCntZero.clone();
            String s=sc.next();
            for(int j=0;j<s.length();j++) {
                if(j>0) {
                    if(s.charAt(j) != s.charAt(j-1)) {
                        if (wordCnt[s.charAt(j)] >= 1) {
                            grWordCnt --;
                            // System.out.println("group word is not");
                            break;
                        }
                    }
                }
                wordCnt[s.charAt(j)] ++;
            }
            grWordCnt++;
            // System.out.println("current grWordCnt : " + grWordCnt);
        }
        System.out.println(grWordCnt);
    }
}
