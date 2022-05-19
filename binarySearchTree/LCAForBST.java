package binarySearchTree;
/*
 * Given a Binary Search Tree (with all values unique) and two node values. Find the Lowest Common Ancestors of the two nodes in the BST.
 */
public class LCAForBST {
	static BST LCA(BST root, int n1, int n2)
	{
        // code here.    
        if(root == null) return null;
        if((root.val >= n1 && root.val <= n2) || (root.val <= n1 && root.val >= n2)) return root;
        BST left = LCA(root.left,n1,n2);
        BST right = LCA(root.right,n1,n2);
        return (left == null)?right:left;
    }
}
