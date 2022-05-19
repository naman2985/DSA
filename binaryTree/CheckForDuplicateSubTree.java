/*
 * Given a tree, we need to find out if there are duplicate subtree of size 2 or more in the given array
 * Eg:       1
 *         /   \
 *        2     3
 *       / \   / \
 *      5   6 7   2
 *               / \
 *              5   6
 *   contains 2 5 6 subtree and its duplicate value
 */

package binaryTree;

import java.util.HashSet;

public class CheckForDuplicateSubTree {
	static String serialise(BinTree tree,HashSet<String> set) {
		String s = "";
		if(tree == null) return "$";
		String l = serialise(tree.left,set);
        if(l.equals(s)) return s;
		String r = serialise(tree.right,set);
        if(r.equals(s)) return s;
		s += String.valueOf(tree.val) + l + r;
		if(s.length() > 3 && set.contains(s)) return "";
		set.add(s);
		return s;
	}
	static boolean checkDuplicate(BinTree tree) {
		HashSet<String> set = new HashSet<>();
		return serialise(tree,set) == "";
	}
	public static void main(String[] args) {
		BinTree tree = new BinTree(1);
		tree.left = new BinTree(2);
		tree.right = new BinTree(3);
		tree.left.left = new BinTree(5);
		tree.left.right = new BinTree(6);
		tree.right.left = new BinTree(7);
		tree.right.right = new BinTree(2);
		tree.right.right.left = new BinTree(5);
		tree.right.right.right = new BinTree(6);
		
		System.out.println(checkDuplicate(tree));
		System.out.println(checkDuplicate(new BinTree(4)));
		/*
		 *         1
		 *       /   \
		 *      2     3
		 *    /  \   / \
		 *   5    6 7   2
		 *             / \
		 *            5   6
		 */
	}
}
