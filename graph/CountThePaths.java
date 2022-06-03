package graph;
// Given a DAG, and a list of edges, find the number of paths that exist between two given nodes
public class CountThePaths {
	static int find_paths(int[][] edges, int e, int s, int d,int index){
        if(s == d) return 1;
        int paths=0;
        while(index<e && edges[index][0] == s){
            if(edges[index][1] == d){
                paths++;index++;
                continue;
            }
            int i=index;
            while(i<e && edges[i][0] != edges[index][1]){
                i++;
            }
            if(i != e) paths += find_paths(edges,e,edges[i][0],d,i);
            index++;
        }
        return paths;
    }
    
    public int possible_paths(int[][] edges, int n, int s, int d)
    {
        // Code here 
        if(s == d) return 1;
        int e=edges.length;
        int index=0;
        while(index < e && edges[index][0] != s) index++;
        return find_paths(edges,e,s,d,index);
    }
}
