package binarySearchTree;
/*
 * Check if a BST is balanced, a BST is said to be balanced if the height of left subtree and right subtree of each node
 * has a maximum difference of 1
 */
public class CheckForBalancedTree {
	static boolean balance;
    static int max(int a,int b){
        return a>=b?a:b;
    }
    static int checkBalance(BST root,int h){
        if(root ==  null) return h;
        int l = checkBalance(root.left,h+1);
        int r = checkBalance(root.right,h+1);
        if(Math.abs(l-r)>1) balance = false;
        return max(l,r);
    }
    boolean isBalanced(BST root)
    {
	// Your code here
	    balance = true;
	    if(Math.abs(checkBalance(root.left,0) - checkBalance(root.right,0)) > 1) return false;
	    return balance;
    }
}
