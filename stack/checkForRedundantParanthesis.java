package stack;
import java.util.Stack;

/* 
 * Given an arithmetic expression in form of a string. Find out whether it has redundant parenthesis or not. 
 * */

public class checkForRedundantParanthesis {
	static boolean check(String s) {
		Stack<Character> st=new Stack<>();
		int n=s.length();
		for(int i=0;i<n;i++) {
			if(s.charAt(i)==')') {
				char top=st.peek();
				st.pop();
				boolean flag=true;
				while(top!='(') {
					if(top=='+'||top=='-'||top=='*'||top=='%') {
						flag = false;
					}
					top=st.peek();
					st.pop();
				}
				if(flag) return true;
			}
			else st.push(s.charAt(i));
		}
		return false;
	}
	public static void main(String args[]) {
		System.out.println(check("((a+b))"));
		System.out.println(check("(a+(b)/c)"));
		System.out.println(check("(a+b*(c-d))"));
	}
}
