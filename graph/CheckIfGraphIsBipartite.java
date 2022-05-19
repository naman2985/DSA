package graph;

import java.util.*;
// Leetcode problem - 785
public class CheckIfGraphIsBipartite {
	static boolean isBipartite(int[][] graph) {
        int n = graph.length;
        Queue<Integer> q = new LinkedList<>();
        Map<Integer,Character> map = new HashMap<>();
        boolean visited[] = new boolean[n];
        Arrays.fill(visited,false);
        q.add(0);
        visited[0] = true;
        map.put(0,'a');
        while(true){
            if(q.isEmpty()){
                int id = -1;
                for(int i=1;i<n;i++){
                    if(!visited[i]){
                        id = i;
                        q.add(i);
                        visited[i] = true;
                        map.put(i,'a');
                        break;
                    }
                }
                if(id == -1) break;
            }
            int u = q.poll();
            char c = map.get(u);
            for(int v:graph[u]){
                if(visited[v] && map.get(v) == c) return false;
                if(!visited[v]){
                    q.add(v);
                    visited[v] = true;
                    if(c == 'a'){
                        map.put(v,'b');
                    }
                    else map.put(v,'a');
                }
            }
        }
        if(map.size() == n) return true;
        return false;
    }
}
