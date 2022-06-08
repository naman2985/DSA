public class ZigZagArray {
	static int[] convertToZigZag(int[] arr){
		int n=arr.length;
		for(int i=1;i<n;i++){
			if(i%2==1 && arr[i]<arr[i-1]){
				int temp=arr[i];
				arr[i]=arr[i-1];
				arr[i-1]=temp;
			}
			else if(i%2==0 && arr[i]>arr[i-1]){
				int temp=arr[i];
				arr[i]=arr[i-1];
				arr[i-1]=temp;
			}
		}
		for(int i:arr) System.out.print(i + " ");
		return arr;
	}
	public static void main(String[] args) {
		int arr[]={4, 3, 7, 8, 6,2,1};
		convertToZigZag(arr);
	}
}