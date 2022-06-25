package graph;

import java.util.ArrayList;

public class EulerCircuitAndPath {
	public static int isEularCircuitExist(int V, ArrayList<ArrayList<Integer>> adj)
    {
        int odd=0;
        for(int i=0;i<V;i++){
            if(adj.get(i).size()%2!=0) odd++;
        }
        if(odd==0) return 2;
        if(odd==2) return 1;
        return 0;
    }
}
