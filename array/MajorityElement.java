package array;
// Find if there exists an element whose frequency is more than half the array size
public class MajorityElement {
	static void findMajority(int arr[]) {
		int maj=0,count=1,n=arr.length;
		for(int i=1;i<n;i++) {
			if(arr[i]==arr[maj]) count++;
			else count--;
			if(count == 0) {
				maj=i;
				count=1;
			}
		}
		count = 0;
		for(int i=0;i<n;i++) {
			if(arr[i]==arr[maj]) count++;
		}
		if(count > n/2) System.out.println("Majority element:" + maj);
		else System.out.println("No majority element");
	}
	public static void main(String[] args) {
		int arr1[] = {3, 3, 4, 2, 4, 4, 2, 4};
		int arr2[] = {3, 3, 4, 2, 4, 4, 2, 4, 4};
		findMajority(arr1);
		findMajority(arr2);
	}
}
