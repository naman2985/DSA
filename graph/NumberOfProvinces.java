package graph;

import java.util.ArrayList;

public class NumberOfProvinces {
	static void dfs(ArrayList<ArrayList<Integer>> adj,int V, boolean[] visit,int curr){
        for(int i=0;i<V;i++){
            if(adj.get(curr).get(i)==1 && !visit[i]){
                visit[i]=true;
                dfs(adj,V,visit,i);
            }
        }
    }
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        // code here
        boolean visit[]=new boolean[V];
        int prov=0;
        for(int i=0;i<V;i++){
            if(!visit[i]){
                visit[i]=true;
                dfs(adj,V,visit,i);
                prov++;
            }
        }
        return prov;
    }
}
