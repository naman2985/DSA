package graph;

import java.util.ArrayList;

public class TransitiveClosureOfAGraph {
	static ArrayList<ArrayList<Integer>> transitiveClosure(int N, int graph[][])
    {
        // code here
		ArrayList<ArrayList<Integer>> reach= new ArrayList<>();
        for(int k=0;k<N;k++){
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(i==j){
                        graph[i][j]=1;
                        continue;
                    }
                    graph[i][j]=(graph[i][j]==1)||((graph[i][k]==1)&&(graph[k][j]==1))?1:0;
                }
            }
        }
        for(int i=0;i<N;i++){
            reach.add(new ArrayList<>());
            for(int j=0;j<N;j++){
                reach.get(i).add(graph[i][j]);
            }
        }
        return reach;
    }
	public static void main(String[] args) {
		int graph[][]= {
			{0, 0, 1, 0, 1, 1, 0},
			{0, 0, 1, 1, 1, 1, 0},
			{0, 0, 1, 1, 1, 0, 1},
			{0, 1, 1, 1, 1, 0, 1},
			{0, 0, 1, 0, 1, 0, 1},
			{0, 0, 1, 0, 0, 0, 1},
			{1, 1, 0, 1, 0, 1, 0}
		};
		transitiveClosure(7,graph);
	}
}
