package test;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {
	public static void main(String[] args) {
			
		
//		q.offer(5);
//		q.offer(2);
//		q.offer(3);
//		q.offer(7);
//		q.poll();
//		q.offer(1);
//		q.offer(4);
//		q.poll();
//		while(!q.isEmpty()) System.out.println(q.poll());		
		// 3 7 1 4
		
		
		// bfs graph
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
		
		bfs(graph ,1, visited);
	}
	
	static void bfs(int[][] graph, int v, boolean[] visited) {
		Queue<Integer> q = new LinkedList<>();
		
		q.offer(v); // que 넣기
		visited[v] = true; // 방문처리
		
		while(!q.isEmpty()) {
			v = q.poll();
			System.out.println(v);
			
			for(int i : graph[v]) {
				if(!visited[i]) {
					q.offer(i);
					visited[i] = true;
				}
			}
		}
	}
}
