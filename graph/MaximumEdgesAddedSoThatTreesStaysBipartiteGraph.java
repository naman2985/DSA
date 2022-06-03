package graph;

public class MaximumEdgesAddedSoThatTreesStaysBipartiteGraph {
	static int one = 0,two = 0,e;
	static void maxEdgesUtil(int[][] edges,int index,boolean isOne) {
		if(isOne) one++;
		else two++;
		if(index==-1) return;
		int temp = edges[index][0];
		while(index<e && edges[index][0] == temp) {
			int i=index+1;
			while(i<e && edges[i][0] != edges[index][1]) i++;
			if(i == e) i=-1;
			maxEdgesUtil(edges,i,!isOne);
			index++;
		}
	}
	
	static int maxEdges(int[][] edges) {
		e = edges.length;
		maxEdgesUtil(edges,0,true);
		return one*two - e; 
	}
	public static void main(String[] args) {
		int	edges[][] = {
			{1, 2},
	        {1, 3},
	        {2, 4},
	        {3, 5},
	        {2, 5}
		};
		System.out.println(maxEdges(edges));
	}
}
