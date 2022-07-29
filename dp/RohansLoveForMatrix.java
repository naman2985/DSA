package dp;

/* given a matrix M = | 1 1 |
				      | 1 0 |
   find (M ^ n)[1][0] modulo 10^9 + 7 
*/

public class RohansLoveForMatrix {
	static int MOD = 1000000007;
    static int nthPower(int n,int dp[]){
        if(n == 1 || n == 2) return 1;
        if(dp[n] != 0) return dp[n] % MOD;
        dp[n] = nthPower(n-1,dp) + nthPower(n-2,dp);
        return dp[n] % MOD;
    }
    static int firstElement(int n) {
        // code here
        int dp[] = new int[n+1];
        return nthPower(n,dp);
    }
}
