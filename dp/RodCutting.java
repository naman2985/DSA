package dp;

public class RodCutting {
	public static int cutRod(int price[], int n) {
        //code here
        int dp[]=new int[n+1];
        dp[0]=0;
        for(int i=1;i<=n;i++){
            int max=price[i-1];
            for(int j=1;j<=i;j++){
                max=Math.max(max,dp[j]+dp[i-j]);
            }
            dp[i]=max;
        }
        return dp[n];
    }
}
