package searchAndSort;

import java.util.Arrays;

/*
 * Given an unsorted array arr[] of n positive integers.
 * Find the number of triangles that can be formed with three different array elements as lengths of three sides of triangles. 
 */
public class CountTheNumberOfPossibleTriangles {
	static int searchElement(int arr[],int n,int sum){
        int beg = 0,end = n-1, mid = (beg + end)/2;
        while(beg < end){
            if(arr[mid] < sum && arr[mid+1] >= sum)
                break;
            else if(arr[mid] < sum)
                beg = mid + 1;
            else end = mid - 1;
            mid = (beg + end)/2;
        }
        return mid;
    }
    
    static int findNumberOfTriangles(int arr[], int n)
    {
        // code here
        Arrays.sort(arr);
        int num = 0;
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                int idx = searchElement(arr,n,arr[i] + arr[j]);
                num += idx - j;
            }
        }
        return num;
    }
}
