public class SpanOfAnArray {
	static int findSpan(int[] arr){
		int min=arr[0],max=arr[0];
		for(int i:arr){
			if(i<min) min=i;
			else if(i>max) max=i;
		}
		return max-min;
	}
	public static void main(String[] args) {
		System.out.print(findSpan(new int[]{1,2,3,4,5,6}));
	}
}