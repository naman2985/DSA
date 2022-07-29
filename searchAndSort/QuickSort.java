package searchAndSort;

public class QuickSort {
	static void quickSort(int arr[], int low, int high)
    {
        // code here
        if(low < high){
            int p = partition(arr,low,high);
            quickSort(arr,low,p-1);
            quickSort(arr,p+1,high);
        }
    }
    static int partition(int arr[], int low, int high)
    {
        // your code here
        int j=low,pivot=arr[high];
        for(int i=low;i<=high;i++){
            if(arr[i]<=pivot){
                int temp=arr[j];
                arr[j++]=arr[i];
                arr[i]=temp;
            }
        }
        return j-1;
    }
    public static void main(String []args) {
		int[] arr = {13, 10, 18, 3, 11, 15, 20, 1, 6, 12};
		quickSort(arr, 0, 9);
		for(int i:arr) System.out.print(i + " ");
	}
}
