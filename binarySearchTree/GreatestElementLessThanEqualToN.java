package binarySearchTree;
/*
 * Given a binary search tree and a number N, find the greatest number in the binary search tree that is less than or equal to N. 
 */
public class GreatestElementLessThanEqualToN {
	public static int findMaxForN(BST node, int val)
    {
        if(node == null) return Integer.MIN_VALUE;
        int n;
        if(node.val > val) n = findMaxForN(node.left,val);
        else n = findMaxForN(node.right,val);
        return (node.val <= val && node.val > n)?node.val:n;
    }
}
