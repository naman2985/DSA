/*
 * Given a binary matrix containing at least one 1. Find the distance to the closest cell having value 1 for every cell in the matrix
 * Distance is calculated as |j1-j2| + |i1-i2|
 */
//TBC


package queue;
//import java.util.*;
public class NearestCellHavingOneInABinaryMatrix {
	/*static int[][] closestOne(int mat[][],int r,int c){
		int[][] graph = new int[r][c];
		Queue<Integer> q = new LinkedList<>();
		boolean[] v = new boolean[r*c];
		int[][] dist = new int[r][c];
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				graph[i][j] = i*c + j + 1;
				if(mat[i][j] == 1) {	
					q.add(graph[i][j]);
					v[i*c + j + 1] = true;
				}
				v[i] = false;
			}
		}
		
		while(!q.isEmpty()) {
			int temp = q.poll();
			for(int i=0;i<)
		}
	}*/
	public static void main(String[] args) {
		System.out.println("hello world");
	}
}
