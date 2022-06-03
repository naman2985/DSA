package array;

public class FrequencyInSortedArray {
	static void findFrequency(int arr[]) {
		int temp=1,curr=arr[0],n=arr.length;
		for(int i=1;i<n;i++) {
			if(arr[i] == curr) temp++;
			else {
				System.out.println(curr + ":" +temp);
				temp=1;
				curr=arr[i];
			}
		}
		System.out.println(curr + ":" +temp);
	}
	public static void main(String[] args) {
		int[] arr={10,10,10,25,31,31,32,32,32,32};
		findFrequency(arr);
	}
}
