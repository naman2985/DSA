package searchAndSort;
// leetcode  #34
public class FirstAndLastIndexOfAnElementInSortedArray {
	public static int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        if(n  == 0) return new int[]{-1,-1};
        int b1 = 0,e1 = n-1;
        int b2 = 0, e2 = n-1;
        int first = (b1 + e1)/2, last = (b2 + e2)/2;
        while(b1 <= e1 && b2 <= e2){
            if(nums[first] < target) b1 = first + 1;
            else if(nums[first] > target || (first > 0 && nums[first-1] == target)) e1 = first - 1;
            first = (b1 + e1)/2;
            
            if(nums[last] < target || (last < n-1 && nums[last+1] == target)) b2 = last + 1;
            else if(nums[last] > target) e2 = last - 1;
            last = (b2 + e2)/2;
            
            if((nums[first] == target && (first == 0 || nums[first-1] != target)) && (nums[last] == target && (last == n-1 || nums[last+1] != target)))
                break;
        }
        return nums[first] == target?new int[]{first,last}:new int[]{-1,-1};
    }
}
