package dp;
/*
 * Given two strings s and t. Return the minimum number of operations required to convert s to t.
	The possible operations are permitted:
	
	1. Insert a character at any position of the string.
	2. Remove any character from the string.
	3. Replace any character from the string with any other character.
 */
public class EditDistance {
	static public int editDistance(String s, String t) {
        // Code here
        int sl=s.length(),tl=t.length(),dp[][]=new int[2][tl+1];
        for(int i=0;i<=tl;i++) dp[0][i]=i;
        for(int i=1;i<=sl;i++){
            dp[i%2][0]=i;
            for(int j=1;j<=tl;j++){
                if(s.charAt(i-1)==t.charAt(j-1))
                    dp[i%2][j]=dp[(i-1)%2][j-1];
                else 
                    dp[i%2][j] = 1 + Math.min(dp[(i - 1) % 2][j],
                                Math.min(dp[i % 2][j - 1],dp[(i - 1) % 2][j - 1]));
            }
        }
        return dp[sl%2][tl];
    }
}
