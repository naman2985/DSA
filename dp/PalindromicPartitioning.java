package dp;

import java.util.Arrays;

public class PalindromicPartitioning {
	static boolean isPalindrome(String s,int i,int j){
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)) return false;
            i++;j--;
        }
        return true;
    }
    static int palindromicPartition(String str)
    {
        // code here
        int n= str.length();
        int partitions[] = new int[n+1];
        Arrays.fill(partitions,Integer.MAX_VALUE);
        partitions[0]=-1;
        partitions[1]=0;
        
        for(int i=1;i<n;i++){
            for(int j=i+1;j<=n;j++){
                partitions[j]=Math.min(partitions[j-1]+1,partitions[j]);
                if(isPalindrome(str,i-1,j-1)){
                    partitions[j]=Math.min(partitions[j],partitions[i-1]+1);
                }
            }
        }
        return partitions[n];
    }
}
