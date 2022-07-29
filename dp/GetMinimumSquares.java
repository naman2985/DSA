package dp;

import java.util.Arrays;

// Given a number N. Find the minimum number of squares of any number that sums to N.
public class GetMinimumSquares {
	static int MinSquares(int n)
    {
        // Code here
        int dp[] = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i=1;i<=n;i++){
            int s = (int)Math.sqrt(i);
            while(s > 0){
                dp[i] = Math.min(dp[i], dp[i-s*s] + 1);
                s--;
            }
        }
        return dp[n];
    }
}
