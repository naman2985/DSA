/*
 * Given an array, check if the array represents a binary search tree traversal
 * Eg: {2,4,3} represents a binary search tree traversal while {2,4,1} doesn't
 * 
 * {40,30,35,80,100}
 *            40
 * 			/    \
 * 		   30     80
 *          \      \  
 *           35    100
 */

package stack;
import java.util.Stack;
public class PreorderTraversalOfABinarySearchTree {
	static boolean checkIfPreorder(int arr[],int n) {
		Stack<Integer> st = new Stack<>();
		int root = Integer.MIN_VALUE;
		for(int i=0;i<n;i++) {
			if(arr[i]<root) return false;
			// While the elements on the top of the stack lie on the left sub-tree of the current element keep removing them 
			while(!st.empty() && st.peek()<arr[i]) {
				root = st.peek();
				st.pop();
			}
			st.push(arr[i]);
		}
		return true;
	}
	public static void main(String[] args) {
		int arr1[] = {40,30,35,80,100};
		int arr2[] = {2,4,1};
		System.out.println(checkIfPreorder(arr1, 5));
		System.out.println(checkIfPreorder(arr2, 3));
	}
}
