package array;

public class ArrangePositiveAndNegativeNumbers {
	static int[] arrange(int[] arr) {
		int idx=0,n=arr.length;
		for(int i=0;i<n;i++) {
			if(arr[i]<0) {
				int temp=arr[i];
				arr[i]=arr[idx];
				arr[idx++]=temp;
			}
		}
		for(int i:arr) System.out.print(i + " ");
		return arr;
	}
	public static void main(String[] args) {
		int[] arr = {10,21,-11,-20,15,19,-30};
		arrange(arr);
	}
}
