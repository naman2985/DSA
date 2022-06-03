package graph;

import java.util.ArrayList;

public class DetectCycleInAnUndirectedGraph {
	static boolean[] visit;
    static boolean isCycleUtil(ArrayList<ArrayList<Integer>> adj,int parent,boolean[] visit,int curr){
        visit[curr]=true;
        for(int i:adj.get(curr)){
            if(!visit[i]){
                if(isCycleUtil(adj,curr,visit,i)) return true;
            }
            else if(parent != i){
                return true;
            }
        }
        return false;
    }
    static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        visit=new boolean[V];
        for(int i=0;i<V;i++){
            if(!visit[i]){
                if(isCycleUtil(adj,-1,visit,i)) return true;
            }
        }
        return false;
    }
}
