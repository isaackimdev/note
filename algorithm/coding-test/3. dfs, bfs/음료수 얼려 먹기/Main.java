import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {
    static int n;
    static int m;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int[][] map = new int[n][m];

        for(int i = 0; i<n; i++) {
            String line = sc.next();
            map[i] = Stream.of(line.split("")).mapToInt(Integer::parseInt).toArray();
        }
    
        int count = 0;
        
        // 아직 방문하지 않은 노드면
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if (dfs(map, i, j)) {
                    count ++;
                }
            }
        }

        System.out.println(count);
    }

    static boolean dfs(int[][] map, int x, int y) {
        // 주어진 범위를 벗어나는 경우 종료
        if (x <= -1 || x >= n || y <= -1 || y >= m) {
            return false;
        }
        
        if ( map[x][y] == 0 ) {
            map[x][y] = 1; // 방문처리
            // 상하좌우 위치 재귀 호출
            dfs(map, x-1, y);
            dfs(map, x+1, y);
            dfs(map, x, y-1);
            dfs(map, x, y+1);
            return true;
        }

        return false;
    }

}
