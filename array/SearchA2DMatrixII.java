package array;
// leetcode # 240
public class SearchA2DMatrixII {
	static boolean binSearch(int arr[], int n,int target){
        int start = 0,end = n-1, mid = (start+end)/2;
        while(start <= end){
            if(arr[mid] == target) return true;
            else if(arr[mid] < target){
                start = mid + 1;
                mid = (start + end)/2;
            }
            else {
                end = mid - 1;
                mid = (start + end)/2;
            }
        }
        return false;
    }
    
    static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        for(int i=0;i<m && matrix[i][0] <= target;i++)
            if(binSearch(matrix[i],n,target)) return true;
        return false;
    }
}
