package array;

public class SortByAbsoluteDifference {
	private static void merge(int arr[], int beg,int mid, int end){
        int temp[] = new int[end-beg+1];
        int k = 0, i = beg,j= mid+1;
        while(i<=mid && j <= end){
            if(Math.abs(arr[i]) <= Math.abs(arr[j]))
                temp[k++] = arr[i++];
            
            else temp[k++] = arr[j++];
        }
        while(i <= mid) temp[k++] = arr[i++];
        while(j <= end) temp[k++] = arr[j++];
        
        for(i=beg;i<=end;i++) arr[i] = temp[i-beg];
    }
    
    private static void sort(int arr[], int beg,int end){
        if(beg < end){
            int mid = beg + (end - beg)/2;
            sort(arr,beg,mid);
            sort(arr,mid+1,end);
            merge(arr,beg,mid,end);
        }
    }
    
    static void sortABS(int arr[], int n,int k)
    {
        // add your code here
        for(int i=0;i<n;i++)
            arr[i] -= k;
        
        sort(arr,0,n-1);
        
        for(int i=0;i<n;i++)
            arr[i] += k;
    }
}
