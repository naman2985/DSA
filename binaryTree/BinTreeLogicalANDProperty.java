/*
 * Given a tree containing only 0 and 1 convert the tree such that each node contains and of its two children.
 * Eg:
 * 			1
 *        /   \
 *       1      0
 *     /  \    /  \
 *    0    1  1    1
 */

package binaryTree;

public class BinTreeLogicalANDProperty {
	static BinTree convert(BinTree tree) {
		if(tree.left == null && tree.right == null) return tree;
		int temp=1;
		if(tree.left != null) temp &= convert(tree.left).val;
		if(tree.right != null) temp &= convert(tree.right).val;
		tree.val = temp;
		return tree;
	}
	public static void main(String[] args) {
		BinTree tree = new BinTree(1);
		tree.left = new BinTree(1);
		tree.right = new BinTree(0);
		tree.left.right = new BinTree(1);
		tree.right.left = new BinTree(1);
		tree.right.right = new BinTree(1);
		convert(tree).inorder();
		/*
		 *         1
		 *       /   \
		 *     1      0
		 *      \    / \
		 *       1  1   1
		 *         |
		 *         |
		 *         |
		 *        \ /
		 *         v
		 *         1
		 *       /   \
		 *      1     1
		 *       \   /  \
		 *        1 1    1
		 */
	}
}
