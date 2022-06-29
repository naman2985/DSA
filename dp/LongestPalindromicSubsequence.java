package dp;

import java.util.Arrays;

public class LongestPalindromicSubsequence {
	static String reverse(String s){
        int i=0,j=s.length()-1;
        char[] reverse=new char[s.length()];
        while(i<=j){
            reverse[i]=s.charAt(j);
            reverse[j]=s.charAt(i);
            i++;j--;
        }
        return new String(reverse);
    }
    public static int longestPalinSubseq(String s1)
    {
        //code here
        String s2=reverse(s1);
        int n=s1.length(),dp[][]=new int[n+1][n+1];
        Arrays.fill(dp[0],0);
        for(int i=1;i<=n;i++){
            dp[i][0]=0;
            for(int j=1;j<=n;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1))
                    dp[i][j]=dp[i-1][j-1]+1;
                else dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[n][n];
    }
}
