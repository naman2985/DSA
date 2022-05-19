package binaryTree;
import java.util.*;
public class DFSAndBFS {
	public static void DFS(BinTree tree) {
		Stack<BinTree> st = new Stack<>();
		st.push(tree);
		while(!st.isEmpty()) {
			BinTree temp = st.pop();
			System.out.print(temp.val + " ");
			if(temp.right != null) st.push(temp.right);
			if(temp.left != null) st.push(temp.left);
		}
		System.out.println();
	}
	public static void BFS(BinTree tree) {
		Queue<BinTree> q = new LinkedList<>();
		q.add(tree);
		while(!q.isEmpty()) {
			BinTree temp = q.poll();
			System.out.print(temp.val + " ");
			if(temp.left != null) q.add(temp.left);
			if(temp.right != null) q.add(temp.right);
		}
		System.out.println();
	}
	public static void main(String[] args) {
		BinTree tree = new BinTree(1);
		tree.left = new BinTree(2);
		tree.right = new BinTree(3);
		tree.left.right = new BinTree(4);
		tree.right.left = new BinTree(5);
		tree.right.right = new BinTree(6);
		/*
		 * 		 1
		 *     /   \
		 *    2     3
		 *     \   / \
		 *      4 5   6
		 * 
		 */
		BFS(tree);//1 2 3 4 5 6
		DFS(tree);// 1 3 6 5 2 4
	}
}
