package array;

import java.util.Arrays;

public class MinimumMovesToEqualArrayElements {
	public int minMoves2(int[] nums) {
        int n=nums.length,moves=0;
        Arrays.sort(nums);
        int med=nums[n/2];
        for(int i=0;i<n;i++) moves += Math.abs(nums[i]-med);
        return moves;
    }
}
