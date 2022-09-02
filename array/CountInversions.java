package array;
/*
 * Given an array, find all the pair of elements which are not in non-decreasing order
 * Eg: {1,2,6,3,2,9}
 * for the above array the following would be the inversion pairs:
 * (6,3),(6,2),(3,2)
 */
public class CountInversions {
	private static long inversion;
    
    private static void merge(long arr[],int l, int m,int r){
        long temp[] = new long[r-l+1];
        int k=0,i=l,j=m+1;
        while(i <= m && j <= r){
            if(arr[i] <= arr[j]){
                temp[k++] = arr[i++];
            }
            else{
                inversion += (long)(m-i+1);
                temp[k++] = arr[j++];
            }
        }
        while(i <= m) temp[k++] = arr[i++];
        while(j <= r) temp[k++] = arr[j++];
        
        for(i=l;i<=r;i++) arr[i] = temp[i-l];
    }
    
    private static void mergeSort(long arr[],int l, int r){
        if(l < r){
            int m = (l + r)/2;
            mergeSort(arr,l,m);
            mergeSort(arr,m+1,r);
            merge(arr,l,m,r);
        }
    }
    
    static long inversionCount(long arr[], long m){
        // Your Code Here
        int n = (int)m;
        inversion = 0L;
        mergeSort(arr,0,n-1);
        return inversion;
    }
}
