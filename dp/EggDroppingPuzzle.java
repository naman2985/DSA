package dp;

/*
 * You are given N identical eggs and you have access to a K-floored building from 1 to K.
 * Find the minimum number of steps in worst case to determine the minimum floor from where the egg would break.
 */
public class EggDroppingPuzzle {
	static int eggDrop(int n, int k) 
	{
	    // Your code here
	    int dp[][] = new int[n+1][k+1];
	    for(int j=0;j<=k;j++){
	        dp[0][j]=0;
	        dp[1][j]=j;
	    }
	    for(int i=2;i<=n;i++){
	        dp[i][0]=0;
	        dp[i][1]=1;
	        for(int j=2;j<=k;j++){
	            dp[i][j]=Integer.MAX_VALUE;
	            for(int x=1;x<=j;x++){
    	            dp[i][j]=Math.min(dp[i][j],1+Math.max(dp[i-1][x-1],dp[i][j-x]));
	            }
	        }
	    }
	    return dp[n][k];
	}
}
