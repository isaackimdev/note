import java.util.*;

public class Implement4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int a = sc.nextInt();
        int b = sc.nextInt();
        int d = sc.nextInt();

        int[][] map = new int[n][m];
        for(int i = 0; i<n; i++) {
            for(int j = 0; j<m; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        boolean play = true;
        
        int count = 1;
        int check = 0;

        while(play) {
            

            d+=1;
            if(d%4==0) d=0;
            check ++;
            
            boolean go = false;
            switch(d) {
                case 0 : go = map[a-1][b] == 1 ? false : true;
                break;
                case 1 : go = map[a][b+1] == 1 ? false : true;
                break;
                case 2 : go = map[a+1][b] == 1 ? false : true;
                break;
                case 3 : go = map[a][b-1] == 1 ? false : true;
                break;
            }

            if(go) {                
                map[a][b] = 1;
                switch(d) {
                    case 0 : a--; break;
                    case 1 : b++; break;
                    case 2 : a++; break;
                    case 3 : b--; break;
                }
                count ++;
                check = 0;
            }
             
            if (check > 4) play = false;
        }
        System.out.println(count);
    }
    
}