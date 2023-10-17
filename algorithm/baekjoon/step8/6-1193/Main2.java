import java.util.Scanner;
/**
 * 정답이 아니다.
 * 결과는 같으나 메모리로 인해 실패하는 코드다.
 * 풀이 과정에서 알고리즘 풀이 방식에 인사이트가 있었기에 코드를 저장한다.
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int sum = 0, i=1;
        for(; sum <= x; i++)sum += i;
        while( x >= Math.pow((i), 2) )i++;
        String[][] fractions = new String[i][i];
        for(int j=0;j<i;j++) for(int k=0;k<i;k++) fractions[j][k] = (j+1)+"/"+(k+1);
        int d=0,s=0,e=0;
        String res;       
        if(x==1) res=fractions[s][e];
        else {
            for(int j=0;j<x-1;j++){
                switch(d) {
                    case 0 : // →
                        ++e;
                        d=1;
                        break;
                    case 1 : // ↙
                        ++s;
                        --e;
                        if(e <= 0) d = 2;
                        break;
                    case 2 : // ↓
                        ++s;
                        d=3;
                        break;
                    case 3 : // ↗
                        --s;
                        ++e;
                        if(s <= 0) d = 0;
                        break;
                }
            }
            res=fractions[s][e];
        }
        System.out.println(res);
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
