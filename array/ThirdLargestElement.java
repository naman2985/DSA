public class ThirdLargestElement {
	static int thirdLargest(int[] arr){
		int l=Integer.MIN_VALUE,sl=Integer.MIN_VALUE,tl=Integer.MIN_VALUE;
		for(int i:arr){
			if(i>l){
				tl=sl;
				sl=l;
				l=i;
			} else if(i>sl){
				tl=sl;
				sl=i;
			} else if(i>tl){
				tl=i;
			}
		}
		return tl;
	}
	public static void main(String[] args) {
		int arr[]={56,81,73,90,6,62,18,78,30};
		System.out.print(thirdLargest(arr));
	}
}