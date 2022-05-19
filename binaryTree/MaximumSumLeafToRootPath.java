package binaryTree;

public class MaximumSumLeafToRootPath {
	static int max(int a, int b) {
		return a >= b?a:b;
	}
	static int maxPathSum(BinTree root) {
		if(root == null) return 0;
        int left = maxPathSum(root.left);
        int right = maxPathSum(root.right);
        return root.val + max(left,right);
	}
}
