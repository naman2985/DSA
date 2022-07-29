package dp;

public class PartitionEqualSubsetSum {
	static int equalPartition(int n, int arr[])
    {
        // code here
        int sum=0;
        for(int i=0;i<n;i++) sum+=arr[i];
        if(sum%2 == 1) return 0;
        sum = sum/2;
        boolean dp[][] = new boolean[n+1][sum+1];
        for(int i=0;i<=n;i++) dp[i][0]=true;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=sum;j++){
                dp[i][j]=dp[i-1][j];
                if(j>=arr[i-1]){
                    dp[i][j]=dp[i][j] || dp[i-1][j-arr[i-1]];
                }
            }
        }
        return dp[n][sum]?1:0;
    }
}
