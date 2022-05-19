package graph;

import java.util.*;

public class DFSOfGraph {
	void dfsUtil(int V,ArrayList<ArrayList<Integer>> adj,ArrayList<Integer> dfs,Boolean[] vis,int idx){
        for(int el:adj.get(idx)){
            if(!vis[el]){
                vis[el]=true;
                dfs.add(el);
                dfsUtil(V,adj,dfs,vis,el);
            }
        }
    }
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        Boolean[] vis = new Boolean[V];
        ArrayList<Integer> dfs = new ArrayList<>();
        Arrays.fill(vis,false);
        dfs.add(0);
        vis[0]=true;
        dfsUtil(V,adj,dfs,vis,0);
        return dfs;
    }
}
