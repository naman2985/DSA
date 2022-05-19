package binarySearchTree;

public class SortedArrayToBST {
	static int pre[],i,n;
    static void arrToBST(int[] nums,int start,int end){
        if(start > end){
            return;
        }
        int mid = (start+end)/2;
        pre[i++] = nums[mid];
        arrToBST(nums,start,mid-1);
        arrToBST(nums,mid+1,end);
    }
    public static int[] sortedArrayToBST(int[] nums)
    {
        int n = nums.length;
        pre = new int[n];
        i = 0;
        arrToBST(nums,0,n-1);
        return pre;
    }
}
