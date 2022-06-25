package dp;
/*
 * Starting from any column in row 0 return the largest sum of any of the paths up to row N-1.
 * There are only three possible moves from a cell Matrix[r][c].

	1. Matrix [r+1] [c]
	2. Matrix [r+1] [c-1]
	3. Matrix [r+1] [c+1]
 */
public class MaximumPathSumInMatrix {
	static int maximumPath(int N, int cost[][])
    {
        // code here
        int maxCost[][]=new int[N][N];
        for(int i=0;i<N;i++) maxCost[0][i]=cost[0][i];
        for(int i=1;i<N;i++){
            for(int j=0;j<N;j++){
                int max=maxCost[i-1][j];
                if(j<N-1) max=Math.max(max,maxCost[i-1][j+1]);
                if(j>0) max=Math.max(max,maxCost[i-1][j-1]);
                maxCost[i][j]=max+cost[i][j];
            }
        }
        int max=Integer.MIN_VALUE;
        for(int i=0;i<N;i++){
            max=Math.max(max,maxCost[N-1][i]);
        }
        return max;
    }
}
