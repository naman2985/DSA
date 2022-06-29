package dp;
/*
 * Given an array of positive integers. Find the maximum length of Bitonic subsequence. 
 * A subsequence of array is called Bitonic if it is first increasing, then decreasing.
 */
public class LongestBitonicSubsequence {
	public static int LongestBitonicSequence(int[] arr)
    {
        // Code here
        int n=arr.length,max=1;
        int[] increasing=new int[n];
        increasing[0]=1;
        for(int i=1;i<n;i++){
            int max_here=0;
            for(int j=0;j<i;j++){
                if(arr[j]<arr[i])
                    max_here=Math.max(increasing[j],max_here);
            }
            increasing[i]=max_here+1;
        }
        for(int i=1;i<n;i++){
            int max_here=0;
            for(int j=0;j<i;j++){
                if(arr[j]>arr[i])
                    max_here=Math.max(increasing[j],max_here);
            }
            increasing[i]=Math.max(max_here+1,increasing[i]);
            max=Math.max(max,increasing[i]);
        }
        return max;
    }
}
