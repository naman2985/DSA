package dp;

public class MaximumSumRectangle {
	static int maximumSumRectangle(int r, int c, int m[][]) {
        // code here
        int dp[][] = new int[r+1][c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                dp[i+1][j] = dp[i][j] + m[i][j];
            }
        }
        
        int maxSum = Integer.MIN_VALUE;
        for(int k=1;k<=r;k++){
            for(int i=k;i<=r;i++){
                int sum=0;
                for(int j=0;j<c;j++){
                    sum += dp[i][j] - dp[k-1][j];
                    maxSum = Math.max(maxSum, sum);
                    if(sum < 0) sum = 0;
                }
            }
        }
        return maxSum;
    }
}
