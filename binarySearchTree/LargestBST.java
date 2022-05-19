package binarySearchTree;
//Given a binary tree. Find the size of its largest subtree that is a Binary Search Tree.
public class LargestBST {
	static int greatest;
	static int max(int a,int b) {
		return (a>=b)?a:b;
	}
	static int largest(BST root) {
		if(root == null) return 0;
		if(root.left == null && root.right == null) return 1;
		int left = largest(root.left);
		int right = largest(root.right);
		if((root.left != null && left == 0)||(root.right != null && right == 0)) return 0;
		if((root.left != null && root.val < root.left.val) ||(root.right != null && root.val>root.right.val)) return 0;
		greatest = max(greatest, max(left,right));
		return greatest;
	}
	static int largestBST(BST root) {
		greatest = 0;
		return largest(root);
	}
}