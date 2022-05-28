package graph;

import java.util.*;
// Assuming every node in the graph is connected
public class IterativeDFS {
	static void dfs(int[][] adj,int V) {
		if(V == 0) return;
		Stack<Integer> s = new Stack<>();
		boolean vis[] = new boolean[V];
		Arrays.fill(vis, false);
		s.push(0);
		vis[0]=true;
		while(!s.isEmpty()) {
			int temp = s.pop();
			System.out.print(temp + " ");
			for(int i=V-1;i>=0;i--) {
				if(adj[temp][i] == 1 && !vis[i]) {
					s.push(i);
					vis[i] = true;
				}
			}
		}
	}
	public static void main(String args[]) {
		int arr[][] = {
				{1,0,1,1,1},
				{1,0,0,0,1},
				{0,1,0,1,0},
				{1,1,1,0,1},
				{0,0,1,1,0}
		};
		dfs(arr,5);
	}
}
