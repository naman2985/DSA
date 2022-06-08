package graph;
// Given a Graph of V vertices and E edges and another edge(c - d), the task is to find if the given edge is a Bridge. 
// i.e., removing the edge disconnects the graph.
import java.util.*;
public class BridgeEdgeInAGraph {
	static int isBridge(int V, ArrayList<ArrayList<Integer>> adj,int c,int d)
    {
        // code here
        Queue<Integer> q=new LinkedList<>();
        boolean visit[]=new boolean[V];
        int n=1;
        q.add(c);
        Arrays.fill(visit,false);
        visit[c]=true;
        Integer a = Integer.valueOf(c);
        Integer b = Integer.valueOf(d);
        adj.get(c).remove(a);
        adj.get(d).remove(b);
        while(!q.isEmpty()){
            int t=q.poll();
            for(int i:adj.get(t)){
                if(!visit[i]){
                    q.add(i);
                    visit[i]=true;
                    n++;
                }
            }
        }
        adj.get(c).add(d);
        adj.get(d).add(c);
        int m=1;
        q.add(c);
        Arrays.fill(visit,false);
        visit[c]=true;
        while(!q.isEmpty()){
            int t=q.poll();
            for(int i:adj.get(t)){
                if(!visit[i]){
                    q.add(i);
                    visit[i]=true;
                    m++;
                }
            }
        }
        return n==m?0:1;
    }
}
