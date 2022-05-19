package binarySearchTree;

public class CheckForBST {
	static boolean isBSTUtil(BST root,int min,int max){
        if(root == null) return true;
        if(root.val > max || root.val < min) return false;
        return isBSTUtil(root.left,min,root.val-1) && isBSTUtil(root.right,root.val+1,max);
    }
    boolean isBST(BST root)
    {
        // code here.
        return isBSTUtil(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
}
