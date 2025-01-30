import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.Stream;

class Main2 {
    static public int n, m;
    static public int[][] graph = new int[200][200];

    // 상, 하, 좌, 우
    static public int[] dx = {-1, 1, 0, 0};
    static public int[] dy = {0, 0, -1, 1};
    
    static public int bfs(int x, int y) {
        Queue<Pos> q = new LinkedList<>();
        q.offer(new Pos(x, y));

        while (!q.isEmpty()) {
            Pos pos = q.poll();
            x = pos.getX();
            y = pos.getY();

            for(int i = 0; i < 4; i++) {
                
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 네 방향 체크
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                // 벽 체크
                if (graph[nx][ny] == 0) continue;
                // 처음 가는 길
                if (graph[nx][ny] == 1) {
                    graph[nx][ny] = graph[x][y] + 1;
                    q.offer(new Pos(nx, ny));
                }    
            }
        }
        
        return graph[n-1][m-1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        
        for(int i = 0; i<n; i++) {
            String line = sc.next();
            graph[i] = Stream.of(line.split("")).mapToInt(Integer::parseInt).toArray();
        }

        System.out.println(bfs(0,0));
        
        
        // for(int i = 0; i < n; i++) {
        //     for(int j = 0; j < m; j++) {
        //         System.out.print(graph[i][j]);
        //     }
        //     System.out.println();
        // }
        
    }
}

class Pos {
    private int x;
    private int y;
    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int getX() { return this.x; }
    public int getY() { return this.y; }
}