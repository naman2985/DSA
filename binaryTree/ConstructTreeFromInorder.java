package binaryTree;
import java.util.*;
public class ConstructTreeFromInorder {
	static Set<BinTree> set = new HashSet<>();
	static Stack<BinTree> st = new Stack<>();
	static BinTree buildTree(int in[],int pre[],int n) {
		BinTree root = null;
		for(int i=0,j=0;i<n;) {
			BinTree node = null;
			do {
				node = new BinTree(pre[i]);
				if(root == null) root = node;
				if(!st.isEmpty()) {
					if(set.contains(st.peek())) {
						set.remove(st.peek());
						st.pop().right = node;
					}
					else st.peek().left = node;
				}
				st.push(node);
			} while(pre[i++] != in[j] && i < n);
			node = null;
			while(!st.isEmpty() && j < n && st.peek().val == in[j]) {
				node = st.pop();
				j++;
			}
			if(node != null) {
				set.add(node);
				st.push(node);
			}
		}
		return root;
	}
	
	static void printPostOrder(BinTree tree) {
		if(tree != null) {
			printPostOrder(tree.left);
			printPostOrder(tree.right);
			System.out.println(tree.val);
		}
	}
	
	public static void main(String[] args) {
		int in[] = {4,2,5,1,6,3};
		int pre[] = {1,2,4,5,3,6};
		printPostOrder(buildTree(in,pre,5));
	}
}
