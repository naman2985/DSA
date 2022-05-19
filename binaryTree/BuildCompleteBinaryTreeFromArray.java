package binaryTree;
import java.util.*;
public class BuildCompleteBinaryTreeFromArray {
	static BinTree addNodes(Queue<Integer> q) {
		if(q.isEmpty()) return null;
		BinTree tree = new BinTree(q.poll());
		return tree;
	}
	static BinTree buildCompleteTree(int arr[],int n) {
		Queue<BinTree> q = new LinkedList<>();
		BinTree tree = new BinTree(arr[0]);
		q.add(tree);
		for(int i=1;i<n;i++) {
			BinTree parent = q.poll();
			parent.left = new BinTree(arr[i]);
			q.add(parent.left);
			i++;
			if(i<n) {
				parent.right =  new BinTree(arr[i]);
				q.add(parent.right);
			}
		}
		return tree;
	}
	public static void main(String[] args) {
		int arr[] = {1,2,3,4,5,6,7,8};
		BinTree tree = buildCompleteTree(arr,8);
		tree.inorder();
		/*
		 *         1
		 *       /   \ 
		 *      2     3
		 *    /  \   /  \
		 *   4    5 6    7
		 *  /
		 * 8
		 * 8 4 2 5 1 6 3 7
		 */
	}
}
