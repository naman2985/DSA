package dp;
//Given an array of integers, find the length of the longest (strictly) increasing subsequence from the given array.

public class LongestIncreasingSubsequence {
	static int longestSubsequence(int size, int arr[])
    {
        // code here
        int L[]=new int[size],max=1;
        L[0]=1;
        for(int i=1;i<size;i++){
            int max_here=0;
            for(int j=0;j<i;j++){
                if(arr[j]<arr[i])
                    max_here=Math.max(max_here,L[j]);
            }
            L[i]=1+max_here;
            max=Math.max(max,L[i]);
        }
        return max;
    }
}
