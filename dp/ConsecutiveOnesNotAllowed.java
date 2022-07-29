package dp;
// Count number of binary strings of length n that don't contain consecutive ones
public class ConsecutiveOnesNotAllowed {
	static long MOD = 1000000007;
    static long countStrings(int n) {
        // code here
        long dp[][] = new long[2][n];
        dp[0][0] = dp[1][0] = (long)1;
        for(int i=1;i<n;i++){
            dp[0][i] = (dp[0][i-1] + dp[1][i-1])%MOD;
            dp[1][i] = dp[0][i-1];
        }
        return (dp[0][n-1] + dp[1][n-1])%MOD;
    }
}
