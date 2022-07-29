package searchAndSort;

public class CountingSort {
	public static String countSort(String s)
    {
        // code here
        int count[]=new int[26];
        char arr[]=s.toCharArray();
        for(char c:arr) count[c-'a']+=1;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<26;i++){
            for(int j=0;j<count[i];j++){
                char c = (char)(i+97);
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
