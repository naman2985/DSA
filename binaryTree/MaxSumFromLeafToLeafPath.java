package binaryTree;

public class MaxSumFromLeafToLeafPath {
	static int max;
	static BinTree root;
	static int maxim(int ...a) {
		int max = a[0];
		for(int i : a) {
			if(i>max) max = i;
		}
		return max;
	}
	static int maxSumUtil(BinTree tree) {
		if(tree.left == null && tree.right == null) return tree.val;
		int left = (int)Double.NEGATIVE_INFINITY;
		int right = (int)Double.NEGATIVE_INFINITY;
		if(tree.left != null) left = maxSumUtil(tree.left);
		if(tree.right != null) right = maxSumUtil(tree.right);
		if(tree.left != null && tree.right != null)
			max = maxim(max,tree.val + left + right);
		else if(tree == root)
			max = maxim(max,tree.val + (tree.left == null?0:left) + (tree.right == null?0:right));
		return tree.val + maxim(left,right);
	}
	static int maxSum(BinTree tree) {
		max = (int)Double.NEGATIVE_INFINITY;
		root = tree;
		maxSumUtil(tree);
		return max;
	}
	public static void main(String[] args) {
		BinTree tree = new BinTree(6);
		tree.left = new BinTree(-9);
		tree.right = new BinTree(-10);
		System.out.println(maxSum(tree));
	}
}
