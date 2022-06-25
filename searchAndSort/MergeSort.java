package searchAndSort;

public class MergeSort {
	static void merge(int arr[], int l, int m, int r)
    {
         // Your code here
         int i=l,j=m+1,k=0;
         int[] temp=new int[r-l+1];
         while(i<=m && j<=r){
             if(arr[i]<arr[j]) temp[k++]=arr[i++];
             else temp[k++]=arr[j++];
         }
         while(i<=m) temp[k++]=arr[i++];
         while(j<=r) temp[k++]=arr[j++];
         i=0;
         for(k=l;k<=r;k++,i++){
             arr[k]=temp[i];
         }
    }
    static void mergeSort(int arr[], int l, int r)
    {
        //code here
        if(l<r){
            int mid=l+(r-l)/2;
            mergeSort(arr,l,mid);
            mergeSort(arr,mid+1,r);
            merge(arr,l,mid,r);
        }
    }
}
