package dp;

public class MaximumSumIncreasingSubsequence {
	public static int maxSumIS(int arr[], int n)  
	{  
	    //code here.
	    int dp[]=new int[n];
	    dp[0]=arr[0];
	    for(int i=1;i<n;i++){
	        int sum=0;
	        for(int j=0;j<i;j++){
	            if(arr[i]>arr[j])
	                sum=Math.max(sum,dp[j]);
	        }
	        dp[i]=arr[i]+sum;
	    }
	    int max=dp[0];
	    for(int i=1;i<n;i++) max=Math.max(max,dp[i]);
	    return max;
	}
}
