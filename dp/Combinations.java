package dp;

public class Combinations {
	static int[][] nCk;
    static final int MOD=1000000007;
    static int nCrRec(int n,int r){
        if(n<r) return 0;
        if(r==0 || r==n){
            nCk[n][r]=1;
            return 1;
        }
        if(nCk[n][r]!=0){
            return nCk[n][r];
        } 
        nCk[n][r]=(nCrRec(n-1,r-1)+nCrRec(n-1,r))%MOD;
        return nCk[n][r];
    }
    static int nCr(int n, int r)
    {
        // code here
        r=Math.min(n-r,r);
        if(r<0) return 0;
        nCk=new int[n+1][r+1];
        return nCrRec(n,r)%MOD;
    }
}
