
/*
 * Given a binary tree, check if for every node except the leaves, the value of nodes of binary tree is equal to sum of its
 * left subtree and right subtree
 * Eg:
 * 		3    is a sum tree while  10    is not
 *     / \						 /  \
 *    1   2						20   30
 */
package binaryTree;

import java.util.HashMap;

public class CheckForSumTree {
	static HashMap<BinTree,Integer> map = new HashMap<>();
	static int fillTree(BinTree tree) {
		if(tree == null) return 0;
		if(tree.left == null && tree.right == null) {
			map.put(tree, tree.val);
			return tree.val;
		}
		else map.put(tree, fillTree(tree.left) + fillTree(tree.right));
		return tree.val + map.get(tree);
	}
	static boolean check(BinTree tree) {
		if(tree == null) return true;
		if(!check(tree.left) || !check(tree.right)) return false;
		return tree.val == map.get(tree);
	}
	public static void main(String[] args) {
		BinTree tree = new BinTree(180);
		tree.left = new BinTree(50);
		tree.right = new BinTree(40);
		tree.left.left = new BinTree(30);
		tree.left.right = new BinTree(10);
		tree.right.left = new BinTree(20);
		tree.right.right = new BinTree(10);
		tree.left.right.left = new BinTree(5);
		tree.left.right.right = new BinTree(5);
		tree.right.right.left = new BinTree(7);
		tree.right.right.right = new BinTree(3);
		fillTree(tree);
		System.out.println(check(tree));
		/*
		 *           180
		 *         /    \
		 *       50       40
		 *     /   \    /    \
		 *    30   10  20     10
		 *        /  \       /   \
		 *       5    5     7     3
		 */
	}
}
