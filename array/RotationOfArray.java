package array;
// block swap algorithm
public class RotationOfArray {
	static void rotateUtil(int arr[],int i,int d,int n) {
		if(d == n || d == 0) return;
		if(n - d == d) {  
            swap(arr, i, n - d + i, d);
        } 
		
		else if(d < n - d) { 
            swap(arr, i, n - d + i, d); 
            rotateUtil(arr, i, d, n - d);     
        } 
        else { 
            swap(arr, i, d, n - d); 
            rotateUtil(arr, n - d + i, 2 * d - n, d);
        } 
	}
	
	public static void swap(int arr[], int a,int b, int d) { 
		int i, temp; 
		for(i = 0; i < d; i++) 
		{ 
			temp = arr[a + i]; 
			arr[a + i] = arr[b + i]; 
			arr[b + i] = temp; 
		} 
	} 
	
	static void blockSwap(int arr[],int d) {
		rotateUtil(arr,0,d,arr.length);
	}
	
	// reversal algorithm
	static void reverse(int arr[],int start,int end){
        for(int i=start,j=end;j>i;i++,j--){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
	
	static void reversal(int arr[],int d) {
		int n = arr.length;
		reverse(arr,0,d-1);
        reverse(arr,d,n-1);
        reverse(arr,0,n-1);
	}
}
