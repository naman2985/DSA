package array;

public class LeftRotation {
	static void leftRotate(long arr[], int k,int n)
    {
        k = k % n;
        for(int i=0;i<k/2;i++){
            long temp = arr[i];
            arr[i] = arr[k-i-1];
            arr[k-i-1] = temp;
        }
        for(int i=k;i<k+(n-k)/2;i++){
            long temp = arr[i];
            arr[i] = arr[k+n-i-1];
            arr[k+n-i-1] = temp;
        }
        for(int i=0;i<n/2;i++){
            long temp = arr[i];
            arr[i] = arr[n-i-1];
            arr[n-i-1] = temp;
        }
    }
}
