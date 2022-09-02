package array;

import java.util.Arrays;
/*
 * Given two binary arrays a1 and a2 find the length of the longest span [i,j] (j >= i) such that
 * number of true in a1[i:j] == number of true values in a2[i:j]
 */
public class LongestSpanInTwoBinaryArrays {
	static int longestCommonSum(boolean arr1[], boolean arr2[], int n) {
        // code here
        int sum1 = 0, sum2  = 0, longestSpan = 0;
        int diff[] = new int[2*n+1];
        Arrays.fill(diff,-1);
        for(int i=0;i<n;i++){
            sum1 += arr1[i]?1:0;
            sum2 += arr2[i]?1:0;
            int d = sum1 - sum2;
            if(d != 0 && diff[d + n] == -1) diff[d + n] = i;
            longestSpan = Math.max(longestSpan, i - diff[d + n]);
        }
        return longestSpan;
    }
}
