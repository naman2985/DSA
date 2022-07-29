package dp;

/*
 * Given a value V and array coins[] of size M, the task is to make the change for V cents.
 * Find the minimum number of coins to make the change. If not possible to make change then return -1.
 */
public class NumberOfCoins {
	public static int minCoins(int coins[], int m, int v) 
	{ 
	    // Your code goes here
	    int dp[] = new int[v];
	    for(int i=0;i<v;i++){
	        dp[i] = Integer.MAX_VALUE;
	        for(int j=0;j<m;j++){
	            if(coins[j] == i+1) dp[i] = 1;
	            else if(coins[j] < i+1 && dp[i-coins[j]] != 0) dp[i] = Math.min(dp[i-coins[j]] + 1,dp[i]);
	        }
	        dp[i] = (dp[i] == Integer.MAX_VALUE)?0:dp[i];
	    }
	    return dp[v-1] == 0?-1:dp[v-1];
	}
}
