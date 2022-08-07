package dp;
// Given a value val, find the number of combinations of 3, 5, 10 whose sum is equal to val. 
public class ReachAGivenScore {
	static public int count(int n) {
        int dp[] = new int[n+1];
        dp[0] = 1;
        for(int i=3;i<=n;i++)
            dp[i] += dp[i-3];
        for(int i=5;i<=n;i++)
            dp[i] += dp[i-5];
        for(int i=10;i<=n;i++)
            dp[i] += dp[i-10];
        return dp[n];
    }
}
