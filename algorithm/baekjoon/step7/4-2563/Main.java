import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[][] whiteBoard = new int[100][100];
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int[][] blackPapers = new int[n][2];
        int blackSpace=0;
        for(int i=0;i<n;i++){
            int leftMargin=sc.nextInt();
            int bottumMargin=sc.nextInt();
            blackPapers[i][0]=leftMargin;
            blackPapers[i][1]=bottumMargin;
        }
        for(int i=0;i<n;i++){
            for(int j=blackPapers[i][0]; j<blackPapers[i][0]+10; j++) {
                for(int k=blackPapers[i][1]; k<blackPapers[i][1]+10; k++) {
                    whiteBoard[j][k]=1;
                }
            }
        }
        for(int i=0;i<100;i++) {
            for(int j=0;j<100;j++) {
                //System.out.print(whiteBoard[i][j] +" ");
                if (whiteBoard[i][j] == 1) blackSpace++;
            }
            //System.out.println();
        }
        System.out.println(blackSpace);
    }
}
