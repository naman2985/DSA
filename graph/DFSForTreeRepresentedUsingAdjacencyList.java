package graph;

// the solution given here works only if the adjacency list contains nodes in a specific order 
public class DFSForTreeRepresentedUsingAdjacencyList {
	static int n;
	static void dfsUtil(int[][] adj,int index) {
		int temp = adj[index][0];
		System.out.print(temp + " ");
		if(index == -1) return;
		while(index < n && adj[index][0] == temp) {
			int i=index;
			while(i<n && adj[i][0] != adj[index][1]) i++;
			if(i == n) System.out.print(adj[index][1] + " ");
			else dfsUtil(adj,i);
			index++;
		}
	}
	
	static void DFS(int[][] adj) {
		n=adj.length;
		dfsUtil(adj,0);
	}
	public static void main(String[] args) {
		int edges[][] = {
			{1,2},{1,3},{2,4},{3,5}
		};
		DFS(edges);
	}
}
