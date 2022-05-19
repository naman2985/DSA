package binaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

class Graph{
	ArrayList<Integer> arr;
	HashMap<Integer,HashSet<Integer>> adj;
	private int size;
	Graph(int n){
		size = n;
		arr = new ArrayList<>();
		for(int i=0;i<n;i++) {
			arr.add(i);
		}
		adj = new HashMap<>();
	}
	void addNode() {
		arr.add(size);
		size++;
	}
	void addEdge(int i,int j) {
		if(adj.containsKey(i)) {
			HashSet<Integer> set = adj.get(i);
			set.add(j);
			adj.put(i,set);
		}
		else {
			HashSet<Integer> set = new HashSet<>();
			set.add(j);
			adj.put(i, set);
		}
	}
}
public class CheckIfAGraphIsATree {
	static boolean check(Graph graph) {
		Queue<Integer> q = new LinkedList<>();
		HashMap<Integer,Boolean> vis = new HashMap<>();
		int n = graph.arr.size();
		for(int i=0;i<n;i++) {
			vis.put(i, false);
		}
		q.add(graph.arr.get(0));
		while(!q.isEmpty()) {
			int node = q.poll();
			if(vis.get(node) == true) return false;
			vis.put(node, true);
			HashSet<Integer> set = graph.adj.get(node);
			Iterator<Integer> i = set.iterator();
			while(i.hasNext()) {
				q.add(i.next());
			}
		}
		for(int i = 0;i<n;i++) {
			if(vis.get(i) == false) return false;
		}
		return true;
	}
	public static void main(String[] args) {
		Graph g = new Graph(5);
		g.addEdge(0, 1);
		g.addEdge(1, 4);
		g.addEdge(1, 2);
		g.addEdge(2, 3);
		g.addEdge(3, 4);
		System.out.println(check(new Graph(1)));
	}
}
