import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        int[][] graph = new int[][] {
            {},
            {2, 3, 8},
            {1, 7},
            {1, 4, 5},
            {3, 5},
            {3, 4},
            {7},
            {2, 6, 8},
            {1, 7}
        };

        boolean[] visited = new boolean[9];

        bfs(graph, 1, visited);
    }

    static void bfs(int[][] graph, int v, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        
        q.offer(v);
        visited[v] = true;

        while( !q.isEmpty() ) {
            v = q.poll();
            System.out.print(v + " ");

            for(int i : graph[v]) {
                if (!visited[i]) {
                    q.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
}
