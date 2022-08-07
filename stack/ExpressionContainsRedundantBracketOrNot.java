package stack;

import java.util.Stack;

public class ExpressionContainsRedundantBracketOrNot {
	public static int checkRedundancy(String s) {
        // code here
        Stack<Integer> st = new Stack<>();
        int n = s.length();
        for(int i=0;i<n;i++){
            if(s.charAt(i) == '(') st.push(i);
            else if(s.charAt(i) == ')'){
                int temp = st.pop();
                if(s.charAt(i-1) == ')'){
                    if(s.charAt(temp + 1) == '(')
                        return 1;
                }
                if(i - temp <= 2) return 1;
            }
        }
        return 0;
    }
}
