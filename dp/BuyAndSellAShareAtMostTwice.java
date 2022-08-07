package dp;

public class BuyAndSellAShareAtMostTwice {
	public static int maxProfit(int n, int[] arr) {
        // code here
        int dp[] = new int[n];
        int m = arr[n-1];
        for(int i=n-2;i>=0;i--){
            if(m < arr[i]){
                m = arr[i];
                dp[i] = dp[i+1];
            }
            else dp[i] = Math.max(m - arr[i], dp[i+1]);
        }
        m = arr[0];
        for(int i=1;i<n;i++){
            if(m > arr[i]){
                m = arr[i];
                dp[i] = Math.max(dp[i-1], dp[i]);
            }
            else dp[i] = Math.max(dp[i] + arr[i] - m, dp[i-1]);
        }
        return dp[n-1];
    }
}
