package array;

public class NonDecreasingArray {
	static boolean checkPossibility(int[] nums) {
        int n=nums.length;
        boolean mod=false;
        for(int i=1;i<n;i++){
            if(nums[i]<nums[i-1]){
                if(mod==true) return false;
                if(i>1 && nums[i-2]>nums[i]) nums[i]=nums[i-1];
                else nums[i-1]=nums[i];
                mod=true;
            }
        }
        return true;
    }
}
