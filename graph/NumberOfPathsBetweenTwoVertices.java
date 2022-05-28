package graph;

import java.util.ArrayList;
public class NumberOfPathsBetweenTwoVertices {
	 public int countPaths(int V, ArrayList<ArrayList<Integer>> adj, int source,int destination) {
		// Code here
        if(source == destination) return 1;
        int count=0;
        for(int i:adj.get(source)){
            count += countPaths(V,adj,i,destination);
        }
        return count;
	}
}
