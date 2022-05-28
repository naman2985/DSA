package graph;
import java.util.*;
/*
 * We are given a matrix that contains different values in each cell.
 * Our aim is to find the minimal set of positions in the matrix such that the entire matrix can be traversed starting from the positions in the set.  
 * We can move only to those neighbors that contain values less than or equal to the current cell’s value. 
 * A neighbor of the cell is defined as the cell that shares a side with the given cell.
 */
class SortByKey implements Comparator<Pair<Integer,Pair<Integer,Integer>>>{
	public int compare(Pair<Integer,Pair<Integer,Integer>> a,Pair<Integer,Pair<Integer,Integer>> b) {
		return a.getKey() - b.getKey();
	}
}
public class MinimumInitialVerticesToTraverseWholeMatrixWithGivenConditions {
	static void dfs(int i,int j,Boolean visit[][],int adj[][],int M,int N) {
		visit[i][j] = true;
		if(i+1<M && adj[i+1][j]<=adj[i][j] && !visit[i+1][j]) {
			dfs(i+1,j,visit,adj,M,N);
		}
		if(j+1<N && adj[i][j+1]<=adj[i][j] && !visit[i][j+1]) {
			dfs(i,j+1,visit,adj,M,N);
		}
		if(i-1>=0 && adj[i-1][j]<=adj[i][j] && !visit[i-1][j]) {
			dfs(i-1,j,visit,adj,M,N);
		}
		if(j-1>=0 && adj[i][j-1]<=adj[i][j] && !visit[i][j-1]) {
			dfs(i,j-1,visit,adj,M,N);
		}
	}
	static void printMinimalVertices(int[][] adj,int M,int N) {
		ArrayList<Pair<Integer,Pair<Integer,Integer>>> nodes = new ArrayList<>();
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				nodes.add(new Pair<Integer,Pair<Integer,Integer>>(adj[i][j],new Pair<Integer,Integer>(i,j)));
			}
		}
		Collections.sort(nodes, new SortByKey());
		Boolean visit[][] = new Boolean[N][M];
		for(int i=0;i<N;i++) {
			Arrays.fill(visit[i], false);
		}
		for(int i=N*M-1;i>=0;i--) {
			if(!visit[nodes.get(i).getValue().getKey()][nodes.get(i).getValue().getValue()]) {
				System.out.println(nodes.get(i).getValue().getKey() +" " + nodes.get(i).getValue().getValue());
				dfs(nodes.get(i).getValue().getKey(),nodes.get(i).getValue().getValue(),visit,adj,M,N);
			}
		}
	}
	public static void main(String[] args) {
		int mat[][] = {
			{1,2,3},
			{2,3,1},
			{1,1,1}
		};
		printMinimalVertices(mat,3,3);
	}
}
