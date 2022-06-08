public class FirstAndLastIndex {
	static void findIndices(int[] arr,int x){
		int n=arr.length,m=n/2,l=0,h=n-1;
		int first=-1,last=-1;
		while(l<=h){
			if(arr[m]==x && (m==0||arr[m-1]!=x)){
				first=m;
				break;
			}
			else if(arr[m]>=x){
				h=m-1;
				m=(l+m)/2;
			}
			else{
				l=m+1;
				m=(h+m)/2;
			}
		}
		System.out.println("First index:" + first);
		m=n/2;l=0;h=n-1;
		while(l<=h){
			if(arr[m]==x && (m==n-1||arr[m+1]!=x)){
				last=m;
				break;
			}
			else if(arr[m]>x){
				h=m-1;
				m=(l+m)/2;
			}
			else{
				l=m+1;
				m=(h+m)/2;
			}
			m=(m>=l)?m:l;
		}
		System.out.println("Last index:" + last);
	}
	public static void main(String[] args) {
		int arr[]={1,1,2,2,2,3,3};
		findIndices(arr,3);
	}
}