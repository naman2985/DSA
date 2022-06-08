public class CheckSubsequence {
	static boolean isSubsequence(String str,String sub){
		int m=sub.length(),n=str.length();
		int i=0;
		for(int j=0;i<m&&j<n;j++){
			if(sub.charAt(i)==str.charAt(j)) i++;
		}
		if(i==m) return true;
		return false;
	}
	public static void main(String[] args) {
		String str="abcd",sub="ad";
		if(isSubsequence(str,sub))
			System.out.println("Is a subsequence");
		else System.out.println("Is not a subsequence");
	}
}