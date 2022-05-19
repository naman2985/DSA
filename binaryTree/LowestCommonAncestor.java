package binaryTree;

public class LowestCommonAncestor {
	static BinTree lca(BinTree root, int n1,int n2)
	{
		// Your code here
		/*if(root == null) return null;
		if(root.val == n1 || root.val == n2) return root;
		if(contains(root.left,n1) && contains(root.right,n2) ||
		contains(root.right,n1) && contains(root.left,n2)) return root;
		BinTree l = lca(root.left,n1,n2);
		BinTree r = lca(root.right,n1,n2);
		if(l != null) return l;
		return r;*/
		if(root == null) return null;
		if(root.val == n1 || root.val == n2) return root;
		BinTree l = lca(root.left,n1,n2);
		BinTree r = lca(root.right,n1,n2);
		if(l != null && r != null) return root;
		return l == null?r:l;
	}
	/*
	 * 		 5
	 *     /   \
	 *    1     9
	 *     \   /
	 *      4 7
	 */
}
