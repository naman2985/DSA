package graph;
import java.util.*;
public class BFSOfGraph {
	public static ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> arr = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        boolean[] v = new boolean[V];
        Arrays.fill(v,false);
        q.add(0);
        v[0]=true;
        while(!q.isEmpty()){
            int temp = q.poll();
            for(int i:adj.get(temp)){
                if(!v[i]){
                    q.add(i);
                    v[i]=true;
                }
            }
            arr.add(temp);
        }
        return arr;
    }
}
