import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int max=0,mr=0,mc=0;
        int[][] A=new int[9][9];
        for(int i=0;i<9;i++)for(int j=0;j<9;j++)A[i][j]=sc.nextInt();
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(max<A[i][j]){
                    max=A[i][j];
                    mr=i;
                    mc=j;
                }
            }
        }
        System.out.println(max+"\n"+(mr+1)+" "+(mc+1));
    }
}
