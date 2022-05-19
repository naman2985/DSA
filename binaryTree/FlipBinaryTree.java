/*
 * Given a binary tree, flip the binary tree to the right direction. The leftmost node becomes the root of the flipped tree and its parent
 * becomes its right child and its immediate right sibling becomes its left child.
 */

// To be tried again
package binaryTree;

public class FlipBinaryTree {
	static BinTree flip(BinTree tree) {
		if(tree == null) return tree;
		if(tree.left == null && tree.right == null) return tree;
		BinTree flipped = flip(tree.left);
		flipped = flipped == null ? tree:flipped;
		if(tree.left != null) {
			tree.left.left = tree.right;
			tree.left.right = tree;
			tree.right = null;
		}
		tree.left = tree.right;
		return flipped;
	}
	public static void main(String[] args) {
		BinTree tree = new BinTree(1);
		tree.left = new BinTree(2);
		tree.right = new BinTree(3);
		tree.left.right = new BinTree(4);
		tree.right.left = new BinTree(5);
		tree.right.right = new BinTree(6);
		
		flip(tree).inorder();
	}
}
