package dp;

public class SubsetSumProblem {
	static Boolean isSubsetSum(int n, int arr[], int sum){
        // code here
        int dp[][] = new int[n+1][sum+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=sum;j++){
                dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                if(arr[i-1]<=j){
                    dp[i][j] = Math.max(dp[i][j],dp[i-1][j-arr[i-1]] + arr[i-1]);
                    if(dp[i][j] == sum) return true;
                }
            }
        }
        return false;
    }
}
