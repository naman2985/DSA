package dp;

import java.util.Arrays;
// leetcode # 1220
public class CountVowelsPermutation {
	static int MOD = 1000000007;
    public static int countVowelPermutation(int n) {
        int dp[][] = new int[n][5];
        Arrays.fill(dp[0], 1);
        for(int j=1;j<n;j++){
            int a=dp[j-1][0], e=dp[j-1][1], i=dp[j-1][2],o=dp[j-1][3],u=dp[j-1][4];
            dp[j][0] = ((e + i) % MOD + u) % MOD;
            dp[j][1] = (a + i) % MOD;
            dp[j][2] = (e + o) % MOD;
            dp[j][3] = i;
            dp[j][4] = (i + o) % MOD;
        }
        return (((dp[n-1][0] + dp[n-1][1]) % MOD + (dp[n-1][2] + dp[n-1][3]) % MOD)%MOD + dp[n-1][4]) % MOD;
    }
}
