package array;

public class MoveAllNegativeElementsToEnd {
	public static void segregateElements(int arr[], int n)
    {
        // Your code goes here
        int a[] = new int[n], k=0;
        for(int i=0;i<n;i++){
            if(arr[i] >= 0) a[k++] = arr[i];
        }
        for(int i=0;i<n;i++){
            if(arr[i] < 0) a[k++] = arr[i];
        }
        for(int i=0;i<n;i++){
            arr[i] = a[i];
        }
    }
}
