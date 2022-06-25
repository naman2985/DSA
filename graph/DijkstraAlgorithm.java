package graph;

import java.util.ArrayList;
import java.util.Arrays;

public class DijkstraAlgorithm {
	static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        // Write your code here
        boolean visit[]=new boolean[V];
        int dist[]=new int[V];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[S]=0;
        while(true){
            boolean allVisited=true;
            int min=Integer.MAX_VALUE,minId=-1;
            for(int i=0;i<V;i++){
                if(!visit[i] && dist[i]<min){
                    min=dist[i];
                    minId=i;
                    allVisited=false;
                }
            }
            if(allVisited) break;
            visit[minId]=true;
            for(ArrayList<Integer> i:adj.get(minId)){
                dist[i.get(0)]=Math.min(dist[minId]+i.get(1),dist[i.get(0)]);
            }
        }
        return dist;
    }
}
