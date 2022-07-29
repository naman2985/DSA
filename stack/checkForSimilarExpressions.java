/* Given two arithmetic expressions check whether the two expressions are similar or not.
 * Both the expressions can or can't have a parenthesis.
 * Assumes every variable to be a distinct small-case letter.
 * Eg: a-(b+c) and a-b-c are similar while -(a+b) and -a+b are not
 */

package stack;
import java.util.Stack;
public class CheckForSimilarExpressions {
	static boolean localSign(String s,int i) {
		if(i==0) return true;
		if(s.charAt(i-1)=='-') return false;
		return true;
	}
	
	static void eval(String s,int[] v,boolean add) {
		Stack<Boolean> st = new Stack<>();
		st.push(true);
		int i=0,n=s.length();
		while(i<n) {
			if(s.charAt(i)=='+'||s.charAt(i)=='-') {
				i++;
				continue;
			}
			//Check for a sign just before '('
			if(s.charAt(i)=='(') {
				if(localSign(s,i))
					st.push(st.peek());
				else st.push(!st.peek());
			}
			// remove the local sign before closing the parenthesis
			else if(s.charAt(i)==')')
				st.pop();
			else {
				if(st.peek())
					v[s.charAt(i)-'a'] += (localSign(s,i)?add?1:-1:add?-1:1);
				// if localSign returns true add will be -1 otherwise add will return 1 for add being true else false
				else
					v[s.charAt(i)-'a'] += (localSign(s,i)?add?-1:1:add?1:-1);
			}
			i++;
		}
	}
	
	static boolean checkForSimilarity(String s1,String s2) {
		int v[]=new int[26];
		eval(s1,v,true);
		eval(s2,v,false);
		for(int i=0;i<26;i++) {
			if(v[i]!=0)
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println(checkForSimilarity("a-(b+c)","a-b-c"));
		System.out.println(checkForSimilarity("-(a+b)", "-a+b"));
	}
}
