package graph;

import java.util.ArrayList;
import java.util.Arrays;
public class PrimMST {
	static int minKey(int V,int[] key,boolean[] visit){
        int min=0;
        while(min<V && visit[min]) min++;
        if(min == V) return -1;
        for(int i=min;i<V;i++){
            if(!visit[i] && key[min]>key[i]) min=i;
        }
        return min;
    }
    static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) 
    {
        // Add your code here
        boolean visit[] = new boolean[V];
        int key[]=new int[V];
        Arrays.fill(visit,false);
        Arrays.fill(key,Integer.MAX_VALUE);
        key[0]=0;
        while(true){
            int minId=minKey(V,key,visit);
            if(minId==-1) break;
            visit[minId]=true;
            for(ArrayList<Integer> i:adj.get(minId)){
                if(!visit[i.get(0)]) key[i.get(0)]=Math.min(key[i.get(0)],i.get(1));
            }
        }
        int sum=0;
        for(int i:key){
            sum+=i;
        }
        return sum;
    }
}
