public class OnlyNonRepeatingElement {
	static int findElement(int[] arr){
		int x=0;
		for(int i:arr) x^=i;
		System.out.print(x);
		return x;
	}
	public static void main(String[] args) {
		int arr[]={4,2,1,7,2,1,7};
		findElement(arr);
	}
}