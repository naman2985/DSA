public class FrequencyOfElement {
	static void findFrequency(int arr[],int x){
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
			m=(m>=l)?m:l;
		}
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
		last=last-first+1;
		System.out.println("Frequency of "+ x + ":" + last);
	}
	public static void main(String[] args) {
		int arr[]={1,1,2,2,2,3,3};
		findFrequency(arr,2);
	}
}