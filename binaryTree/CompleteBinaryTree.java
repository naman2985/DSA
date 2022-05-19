package binaryTree;

import java.util.*;

public class CompleteBinaryTree {
	static BinTree construct(int arr[]) {
		Queue<BinTree> q = new LinkedList<>();
		if(arr.length == 0) return null;
		BinTree tree = new BinTree(arr[0]);
		q.add(tree);
		int i=1,n=arr.length;
		while(i<n) {
			BinTree temp = q.peek();
			if(temp.left == null) {
				temp.left = new BinTree(arr[i++]);
				q.add(tree.left);
			}
			else {
				temp.right = new BinTree(arr[i++]);
				q.add(tree.right);
				q.poll();
			}
		}
		return tree;
	}
	public static void main(String[] args) {
		int arr[]= {1,2,3,4,5,6,7};
		BinTree tree = construct(arr);
		tree.inorder();
		// 1 2 3 4 5 6 7
	}
}
