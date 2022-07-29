package dp;
// Given two strings, find the shortest string having both strings as its subsequence
public class ShortestCommonSupersequence {
	public static int shortestCommonSupersequence(String x,String y,int m,int n)
    {
        //Your code here
        int dp[][] = new int[m+1][n+1];
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(x.charAt(i-1) != y.charAt(j-1))
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                else dp[i][j] = dp[i-1][j-1] + 1;
            }
        }
        return m + n - dp[m][n];
    }
}
