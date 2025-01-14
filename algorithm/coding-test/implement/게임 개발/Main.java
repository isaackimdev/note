// 아래 풀이를 보니, 머리 컨디션에 따라 코드의 상태도 다르다는 걸 알 수 있었다.
// 몇 달 전에는 훨씬 더 깔끔하게 풀었던 코드..
// 일단 오늘 상태는 에너지 다 쓰고, 밤 12시에 작성한 것이라 코드가 좀 별로
// 과거 풀었던 ../../../java/test/implement4.java 를 보면 알 수 있을 것.

import java.util.*;
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int a = sc.nextInt();
        int b = sc.nextInt();
        int d = sc.nextInt();
        
        int[][] map = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();   // 육지 0, 바다 1, 외곽은 바다다.
            }
        }
        
        int count = 1;
        int check = 0;
        boolean play = true;
        while(play) {
            map[a][b] = -1;
            // 1. 왼쪽방향 회전(반 시계 방향)
            // 0 > 3 > 2 > 1 > 0
            d = d == 0 ? 3 : d-1;
            
            // 2. 아직 안가봤으면 ㄱ
            switch ( d ) { // 북 동 남 서, 0 1 2 3
                case 0 : 
                    if ( map[a-1][b] == 0 ) {
                        a -= 1;
                        map[a][b] = -1; // 방문
                        count++;
                        check = 0;
                    } else check++;
                    break;
                case 1 : 
                    if ( map[a][b+1] == 0 ) {
                        b += 1;
                        map[a][b] = -1; // 방문
                        count++;
                        check = 0;
                    } else check++;
                    break;
                case 2 : 
                    if ( map[a+1][b] == 0 ) {
                        a += 1;
                        map[a][b] = -1; // 방문
                        count++;
                        check = 0;
                    } else check++;
                    break;
                case 3 : 
                    if ( map[a][b-1] == 0 ) {
                        b -= 1;
                        map[a][b] = -1; // 방문
                        count++;
                        check = 0;
                    } else check++;
                    break;
            }
            
            if (check == 4) { // 북 동 남 서, 0 1 2 3
                switch ( d ) {
                    case 0 : 
                        if (map[a+1][b] == 1) play = false;
                        else  {
                            a+=1;
                            check = 0;
                        }
                        break; // 북
                    case 1 : 
                        if (map[a][b-1] == 1) play = false;
                        else {
                            b-=1;
                            check = 0;
                        }
                        break; // 동
                    case 2 : 
                        if (map[a-1][b] == 1) play = false;
                        else {
                            a-=1;
                            check = 0;
                        }
                        break; // 남
                    case 3 : 
                        if (map[a][b+1] == 1) play = false;
                        else {
                            b+=1;
                            check = 0;
                        }
                        break; // 서
                }
            }

            // 3. 네 방향 다 가봤으면 방향 유지 뒤로 한 칸. 단 뒤방향이 바다면 멈춤.
            // 뒤가 바다면 멈춘다.

        }
        System.out.println(count);

    }
}