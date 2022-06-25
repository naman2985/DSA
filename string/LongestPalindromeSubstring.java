package string;

// leetcode #5
public class LongestPalindromeSubstring {
	static String oddPalindrome(String s){
        int longest=1,n=s.length();
        String pal=s.substring(0,1);
        for(int i=0;i<n;i++){
            for(int j=1;i+j<n && i-j>=0 && s.charAt(i-j)==s.charAt(i+j);j++){
                if(2*j+1>longest){
                    longest=2*j-1;
                    pal=s.substring(i-j,i+j+1);
                }
            }
        }
        return pal;
    }
    static String evenPalindrome(String s){
        int longest=0,n=s.length();
        if(n<2) return "";
        String pal="";
        for(int i=0;i<n;i++){
            for(int j=1;i+j<n && i-j+1>=0 && s.charAt(i-j+1)==s.charAt(i+j);j++){
                if(2*j>longest){
                    longest=2*j;
                    pal=s.substring(i-j+1,i+j+1);
                }
            }
        }
        return pal;
    }
    public static String longestPalindrome(String s) {
        String even=evenPalindrome(s),odd=oddPalindrome(s);
        return (even.length()>=odd.length())?even:odd;
    }
}
