package searchAndSort;

public class InsertionSort {
	static void insert(int arr[],int i)
	  {
	       // Your code here
	       int temp=arr[i];
	       while(i>0 && temp<arr[i-1]){
	           arr[i]=arr[i-1];
	           i--;
	       }
	       arr[i]=temp;
	  }
	  //Function to sort the array using insertion sort algorithm.
	  public static void insertionSort(int arr[], int n)
	  {
	      //code here
	      for(int i=1;i<n;i++){
	          insert(arr,i);
	      }
	  }
}
