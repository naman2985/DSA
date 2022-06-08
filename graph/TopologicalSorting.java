package graph;
import java.util.*;
public class TopologicalSorting {
	static void topoSortUtil(ArrayList<ArrayList<Integer>> adj,int u,boolean[] visit,Stack<Integer> s){
        visit[u]=true;
        for(int i:adj.get(u)){
            if(!visit[i]) topoSortUtil(adj,i,visit,s);
        }
        s.push(u);
    }
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // add your code here
        Stack<Integer> s = new Stack<Integer>();
        boolean visit[]=new boolean[V];
        int[] sorted=new int[V];
        Arrays.fill(visit,false);
        for(int i=0;i<V;i++){
            if(!visit[i]) topoSortUtil(adj,i,visit,s);
        }
        int i=0;
        while(!s.isEmpty()) sorted[i++]=s.pop();
        return sorted;
    }
}
