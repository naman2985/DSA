package dp;

import java.util.List;

/*
 * leetcode #120
 * Given a triangle array, return the minimum path sum from top to bottom.
 * Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
 * Output: 11
 * Explanation: The triangle looks like:
	   2
	  3 4
	 6 5 7
	4 1 8 3
	The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).
 */
public class Triangle {
	public static int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        for(int i=1;i<n;i++){
            for(int j=0;j<=i;j++){
                int min=0;
                if(j==0) min=triangle.get(i-1).get(j);
                else if(j==i) min=triangle.get(i-1).get(j-1);
                else min=Math.min(triangle.get(i-1).get(j),triangle.get(i-1).get(j-1));
                int curr=triangle.get(i).get(j);
                triangle.get(i).set(j,curr+min);
            }
        }
        int min=Integer.MAX_VALUE;
        for(int i:triangle.get(n-1)){
            System.out.print(i + " ");
            min=Math.min(min,i);
        }
        return min;
    }
}
