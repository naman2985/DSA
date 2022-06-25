package array;

public class ReversalAlgorithmForArrayRotation {
	static void reverse(int[] arr,int a,int b){
        for(int i=a,j=b;i<j;i++,j--){
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
        }
    }
    static void leftRotate(int[] arr, int n, int d) {
        // code here
        d=d%n;
        reverse(arr,0,d-1);
        reverse(arr,d,n-1);
        reverse(arr,0,n-1);
    }
}
