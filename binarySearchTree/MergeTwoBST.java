package binarySearchTree;

import java.util.Stack;

public class MergeTwoBST {
	static void merge(BST root1,BST root2) {
		Stack<BST> s1 = new Stack<>();
		BST c1 = root1;
		Stack<BST> s2 = new Stack<>();
		BST c2 = root2;
		if(root1 == null) {
			root2.inorder();
			return;
		}
		if(root2 == null) {
			root1.inorder();
			return;
		}
		while(c1 != null || !s1.isEmpty() || c2 != null || s2.isEmpty()) {
			if(c1 != null || c2 != null) {
				if(c1 != null) {
					s1.push(c1);
					c1 = c1.left;
				}
				if(c2 != null) {
					s2.push(c2);
					c2 = c2.left;
				}
			}
			else {
				if(s1.isEmpty()) {
					BST temp;
					while(!s2.isEmpty()) {
						c2 = s2.pop();
						temp = c2.left;
						c2.left = null;
						c2.inorder();
						c2.left = temp;
					}
					return;
				}
				if(s2.isEmpty()) {
					BST temp;
					while(!s1.isEmpty()) {
						c1 = s1.pop();
						temp = c1.left;
						c1.left = null;
						c1.inorder();
						c1.left = temp;
					}
					return;
				}
				c1 = s1.pop();
				c2 = s2.pop();
				if(c1.val < c2.val) {
					System.out.print(c1.val + " ");
					c1 = c1.right;
					s2.push(c2);
					c2 = null;
				}
				else {
					System.out.print(c2.val + " ");
					c2 = c2.right;
					s1.push(c1);
					c1 = null;
				}
			}
		}
	}
}
