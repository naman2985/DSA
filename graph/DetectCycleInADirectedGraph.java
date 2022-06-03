package graph;
import java.util.ArrayList;
public class DetectCycleInADirectedGraph {
	static boolean isCyclicUtil(int V, ArrayList<ArrayList<Integer>> adj,int node,boolean[] visit,boolean[] recStack){
        if(recStack[node]) return true;
        if(visit[node]){
            return false;
        }
        visit[node]=true;
        recStack[node]=true;
        for(int j:adj.get(node)){
            if(isCyclicUtil(V,adj,j,visit,recStack)){
                return true;
            }
        }
        recStack[node]=false;
        return false;
    }
    static boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        boolean visit[] = new boolean[V];
        boolean recStack[]=new boolean[V];
        for(int i=0;i<V;i++){
            if(isCyclicUtil(V,adj,i,visit,recStack)) return true;
        }
        return false;
    }
}
