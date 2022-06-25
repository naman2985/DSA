package searchAndSort;

public class SelectionSort {
	static int select(int arr[], int i)
	{
        // code here such that selectionSort() sorts arr[]
        int min=arr[i],id=i,n=arr.length;
        while(i<n){
            if(arr[i]<min){
                min=arr[i];
                id=i;
            }
            i++;
        }
        return id;
	}
	
	static void selectionSort(int arr[], int n)
	{
	    //code here
	    for(int i=0;i<n;i++){
	        int lowest=select(arr,i);
	        int temp=arr[i];
	        arr[i]=arr[lowest];
	        arr[lowest]=temp;
	    }
	}
}
