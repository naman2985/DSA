public class ReverseWords {
	static void reverseWords(String sen){
		int n=sen.length();
		char rev[]=new char[n];
		for(int i=0;i<n;){
			if(sen.charAt(i)==' '){
				rev[i]=' ';
				i++;
			}
			else{
				int j=i;
				while(j<n && sen.charAt(j)!=' ') j++;
				j--;
				int temp=j;
				while(i<=j){
					rev[i]=sen.charAt(j);
					rev[j]=sen.charAt(i);
					i++;j--;
				}
				i=temp+1;
			}
		}
		for(char c:rev) System.out.print(c);
	}
	public static void main(String[] args) {
		String str="   hello     how are you  ";
		reverseWords(str);
	}
}