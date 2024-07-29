package test;

public class DFS {
	public static void main(String[] args) {
		// DFS
		// depth first search, stack, recursive
		int[][] graph = {
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
		
		dfs(graph, 1, visited);
	}
	
	public static void dfs(int[][] graph, int v, boolean[] visited) {
		visited[v] = true; // 방문처리
		System.out.print(v+" ");
		
		for (int i = 0; i < graph[v].length; i++) {
			int v2 = graph[v][i];
			if (!visited[v2]) {
				dfs(graph, v2, visited);
			}
		}
		
		
	}

}
