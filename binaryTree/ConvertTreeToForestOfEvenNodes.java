/*
 * Given a binary tree containing even number of nodes.
 * We can remove any edge from the tree. Find the maximum number of edges that we can remove such that the number of nodes in each subtree(forests)
 * formed by removing the edges remains even
 * 
 */

package binaryTree;
import java.util.*;
public class ConvertTreeToForestOfEvenNodes {
	static Vector<Vector<Integer>> edges = new Vector<Vector<Integer>>();
	static int max;
	static int dfs(boolean[] visit,int node) {
		int num=0,temp=0;
		visit[node] = true;
		for(int i=0;i<edges.get(node).size();i++) {
			if(visit[edges.get(node).get(i)] == false) {
				temp = dfs(visit,edges.get(node).get(i));
				if(temp%2 != 0) num+=temp;
				else max++;
			}
		}
		return num+1;
	}
	static int maxRemoval(int n) {
		boolean visit[] = new boolean[n+2];
		max = 0;
		dfs(visit,1);
		return max;
	}
	public static void main(String[] args) {
		for(int i=0;i<11;i++) {
			edges.add(new Vector<Integer>());
		}
		edges.get(1).add(3);
		edges.get(3).add(1);
		edges.get(1).add(6);
		edges.get(6).add(1);
		edges.get(1).add(2);
		edges.get(2).add(1);
		edges.get(3).add(4);
		edges.get(4).add(3);
		edges.get(6).add(8);
		edges.get(8).add(6);
		edges.get(2).add(7);
		edges.get(7).add(2);
		edges.get(2).add(5);
		edges.get(5).add(2);
		edges.get(4).add(9);
		edges.get(9).add(4);
		edges.get(4).add(10);
		edges.get(10).add(4);
		int min = maxRemoval(10);
		System.out.println(min);
	}
}
