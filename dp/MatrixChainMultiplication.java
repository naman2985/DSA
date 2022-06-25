package dp;
// Given a sequence of matrices, find the most efficient way to multiply these matrices together.
public class MatrixChainMultiplication {
	static int dp[][];
    static int matMulRec(int arr[],int i,int j){
        if(i==j) return 0;
        if(dp[i][j]!= 0) return dp[i][j];
        dp[i][j]=Integer.MAX_VALUE;
        for(int k=i;k<j;k++){
            dp[i][j]=Math.min(dp[i][j],matMulRec(arr,i,k)+matMulRec(arr,k+1,j)+arr[i-1]*arr[k]*arr[j]);
        }
        return dp[i][j];
    }
    static int matrixMultiplication(int N, int arr[])
    {
        // code here
        dp=new int[N][N];
        return matMulRec(arr,1,N-1);
    }
}
