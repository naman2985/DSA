package string;

public class ReverseAString {
	public static String reverseWord(String str)
    {
        // Reverse the string str
        StringBuilder sb = new StringBuilder();
        int n = str.length();
        for(int i=n-1;i>=0;i--)
            sb.append(str.charAt(i));
        return sb.toString();
    }
}
