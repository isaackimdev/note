import java.util.*;
import java.util.stream.*;

public class Main {

    public static int n, m;
    public static int[][] map = new int[201][201];

    // 상 좌 하 우
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, -1, 0, 1};

    public static int bfs(int x, int y) {
        Queue<Pos> q = new LinkedList<>();
        q.offer(new Pos(x, y));

        while(!q.isEmpty()) {
            Pos pos = q.poll();
            x = pos.getX();
            y = pos.getY();

            // 현 위치에서 4방향 확인
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                // 미로 찾기 공간을 벗어난 경우 무시
                if ( nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                // 벽인 경우 무시
                if (map[nx][ny] == 0) continue;
                // 처음 방문하는 경우만 최단 거리 기록
                if (map[nx][ny] == 1) {
                    map[nx][ny] = map[x][y] + 1;
                    q.offer(new Pos(nx, ny));
                }
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0 ;j <m; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }

        return map[n-1][m-1];
        
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt();
        m = sc.nextInt();

        for(int i = 0; i < n; i++) {
            String line = sc.next();
            map[i] = Stream.of(line.split("")).mapToInt(Integer::parseInt).toArray();
        }

        System.out.println(bfs(0, 0));

        
    }

}

class Pos {
    private int x;
    private int y;
    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public int getX() {
        return this.x;
    }
    public int getY() {
        return this.y;
    }
}