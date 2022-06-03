package queue;
import java.util.*;

class Graph{
	private int V;
	private LinkedList<LinkedList<Integer>> adj;//adjacency matrix
	Graph(int v){
		V = v;
		adj = new LinkedList<>();
		for(int i=0;i<v;i++) {
			adj.add(new LinkedList<>());
		}
	}
	
	void addEdge(int u,int v) {
		adj.get(u).add(v);
	}
	
	public void BFS(int s) {
		boolean v[] = new boolean[V];
		Queue<Integer> q = new LinkedList<>();
		q.add(s);
		v[s] = true;
		while(!q.isEmpty()) {
			s = q.poll();
			System.out.print(s+" ");
			Iterator<Integer> i = adj.get(s).listIterator();
			while(i.hasNext()) {
				int x = i.next();
				if(!v[x]) {
					q.add(x);
					v[x] = true;
				}
			}
		}
	}
}

public class BreadthFirstSearch {
	public static void main(String[] args) {
		Graph g = new Graph(4);
		g.addEdge(0, 1);
		g.addEdge(1, 2);
		g.addEdge(1, 3);
		g.addEdge(2, 3);
		g.addEdge(3, 1);
		g.addEdge(3, 0);
		g.BFS(0);// 0 1 2 3
	}
}
