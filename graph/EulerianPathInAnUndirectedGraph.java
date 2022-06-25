package graph;

public class EulerianPathInAnUndirectedGraph {
	static int eulerPath(int N, int graph[][]){
        // code here
        int odd=0;
        for(int i=0;i<N;i++){
            int count=0;
            for(int j=0;j<N;j++){
                if(graph[i][j]==1)
                    count++;
            }
            if(count%2==1) odd++;
            if(odd>2) return 0;
        }
        return 1;
    }
}
