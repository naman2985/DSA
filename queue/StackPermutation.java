/*
 * A stack permutation of objects in the given I/P queue  done by transferring elements from I/P queue to O/P queue with the help of a stack.
 * Given two arrays one I/P and one O/P check whether given output is possible through stack permutation.
 */

package queue;
import java.util.*;
public class StackPermutation {
	public static boolean checkPerm(int a[],int b[],int n) {
		Stack<Integer> s = new Stack<>();
		int j=0;
		for(int i=0;i<n;i++) {
			if(b[j] == a[i]) j++;
			else if(!s.isEmpty() && b[j] == s.peek()) s.pop();
			else s.push(a[i]);
		}
		while(!s.isEmpty()) {
			if(s.pop() != b[j]) return false;
			j++;
		}
		return true;
	}
	public static void main(String[] args) {
		int a[] = {1,2,3};
		int b[] = {2,1,3};
		int c[] = {3,1,2};
		System.out.println(checkPerm(a,b,3));
		System.out.println(checkPerm(a,c,3));
	}
}
