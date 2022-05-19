package binarySearchTree;

//import java.util.HashMap;
class Index{
	int i;
}

public class BSTFromGivenPreorderTraversal {
	static Index i;
	static int n;
	static void util(BST tree,int pre[],int min,int max) {
		if(tree == null || i.i == n) return;
		if(pre[i.i] > max || pre[i.i] < min ||(tree.left != null && tree.right != null)) return;
		if(tree.val > pre[i.i]) tree.left = new BST(pre[i.i++]);
		util(tree.left,pre,min,tree.val-1);
		if(tree.val <= pre[i.i]) tree.right = new BST(pre[i.i++]);
		util(tree.right,pre,tree.val,max);
	}
	static BST constructBST(int pre[]) {
		i = new Index();
		i.i = 1;
		n = pre.length;
		BST tree = new BST(pre[0]);
		util(tree,pre,Integer.MIN_VALUE,Integer.MAX_VALUE);
		return tree;
	}
	public static void main(String[] args) {
		int pre[] = {10, 5, 1, 7, 40, 50};
		constructBST(pre).inorder();
	}
}
