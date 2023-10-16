import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int i=1;
        while(x>Math.pow(i, 2))i++;
        String[][] fractions = new String[i][i];
        for(int j=0;j<i;j++) for(int k=0;k<i;k++) fractions[j][k] = (j+1)+"/"+(k+1);

        // x번째 분수 추출
    }
}



/*
        // 출력

        for(int j=0;j<i;j++) {
            for(int k=0;k<i;k++) {
                System.out.print(fractions[j][k]+" ");
            }
            System.out.println();
        }

        
*/ 
