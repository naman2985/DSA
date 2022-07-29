package dp;

public class BracketsInMatrixChainMultiplication {
	static int dp[][];
    static int brackets[][];
    static char name;
    static int matrixChainDP(int p[],int m,int n){
        if(m>=n) return 0;
        if(dp[m][n] != 0) return dp[m][n];
        dp[m][n] = Integer.MAX_VALUE;
        for(int i=m;i<n;i++){
            int temp = matrixChainDP(p,m,i)+matrixChainDP(p,i+1,n)+p[m-1]*p[i]*p[n];
            if(temp < dp[m][n]){
                dp[m][n]=temp;
                brackets[m][n]=i;
            }
        }
        return dp[m][n];
    }
    
    static void paranthesise(StringBuilder sb,int i,int j,int[][] brackets){
        if(i==j){
            sb.append(name++);
            return;
        }
        sb.append('(');
        paranthesise(sb,i,brackets[i][j],brackets);
        paranthesise(sb,brackets[i][j]+1,j,brackets);
        sb.append(')');
    }
    
    static String matrixChainOrder(int p[], int n){
        // code here
        StringBuilder sb = new StringBuilder("");
        dp=new int[n][n];
        brackets = new int[n][n];
        name = 'A';
        matrixChainDP(p,1,n-1);
        paranthesise(sb,1,n-1,brackets);
        return sb.toString();
    }
}
