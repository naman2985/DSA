import java.util.Arrays;
public class ProductOfArrayExceptSelf {
	static int[] prodArray(int arr[]){
		int n=arr.length,p=1;
		int prod[]=new int[n];
		for(int i=0;i<n;i++){
			prod[i]=p;
			p*=arr[i];
		}
		p=1;
		for(int i=n-1;i>=0;i--){
			prod[i]*=p;
			p*=arr[i];
		}
		for(int i:prod){
			System.out.print(i+" ");
		}
		return prod;
	}
	public static void main(String[] args) {
		int arr[]={-1,1,0,-3,3};
		prodArray(arr);
	}
}