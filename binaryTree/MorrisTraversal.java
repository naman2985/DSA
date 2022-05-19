package binaryTree;
public class MorrisTraversal {
	static void morris(BinTree tree) {
		BinTree curr, prev;
		if(tree == null) return;
		curr = tree;
		while(curr != null) {
			if(curr.left == null) {
				System.out.print(curr.val + " ");
				curr = curr.right;
			}
			else {
				prev = curr.left;
				while(prev.right != null && prev.right != curr) {
					prev = prev.right;
				}
				if(prev.right == null) {
					prev.right = curr;
					curr = curr.left;
				}
				else {
					prev.right = null;
					System.out.print(curr.val + " ");
					curr = curr.right;
				}
			}
		}
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
		morris(tree);
	}
}
