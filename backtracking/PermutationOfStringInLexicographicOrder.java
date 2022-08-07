package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationOfStringInLexicographicOrder {
	static List<String> createPermutations(String s){
        List<String> list = new ArrayList<>();
        int n = s.length();
        if(n == 1){
            list.add(s);
            return list;
        }
        
        char c = s.charAt(0);
        List<String> temp = createPermutations(s.substring(1,n));
        for(String str:temp){
            StringBuilder sb = new StringBuilder(str);
            sb.insert(0, c);
            if(list.size() == 0 || !list.get(list.size()-1).equals(sb.toString()))
                list.add(sb.toString());
        }
        
        for(String str:temp){
            for(int i=1;i<n;i++){
                StringBuilder sb = new StringBuilder(str);
                sb.insert(i, c);
                if(list.size() == 0 || !list.get(list.size()-1).equals(sb.toString()))
                    list.add(sb.toString());
            }
        }
        return list;
    }
    
    public static List<String> find_permutation(String S) {
        // Code here
        char arr[] = S.toCharArray();
        Arrays.sort(arr);
        String s = new String(arr);
        return createPermutations(s);
    }
}
