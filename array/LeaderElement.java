public class LeaderElement {
	static void findLeaders(int[] arr){
		int n=arr.length,m=Integer.MIN_VALUE;
		for(int i=n-1;i>=0;i--){
			if(arr[i]>m){
				System.out.print(arr[i] +" ");
				m=arr[i];
			}
		}
	}
	
	public static void main(String[] args) {
		int arr[]={29,67,46,38,43,24,17,20};
		findLeaders(arr);
	}
}