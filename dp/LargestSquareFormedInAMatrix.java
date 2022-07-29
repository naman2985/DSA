package dp;

/*
 * given a matrix of zeroes and ones, find the largest square made up of 1's in that matrix
 */

public class LargestSquareFormedInAMatrix {
	static int maxSquare(int n, int m, int mat[][]){
        // code here
        int overallMax = 0;
        for(int j=0;j<m;j++)
            if(mat[0][j] == 1){
                overallMax = 1;
                break;
            }
        for(int i=1;i<n;i++){
            overallMax = Math.max(overallMax,mat[i][0]);
            for(int j=1;j<m;j++){
                if(mat[i][j] != 0){
                    mat[i][j] = Math.min(Math.min(mat[i-1][j],mat[i][j-1]),mat[i-1][j-1]) + 1;
                }
                overallMax = Math.max(mat[i][j],overallMax);
                //System.out.print(mat[i][j] + " ");
            }
        }
        return overallMax;
    }
}
