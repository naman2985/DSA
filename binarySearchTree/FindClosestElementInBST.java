package binarySearchTree;
// Given a BST and an integer. Find the least absolute difference between any BST value of the BST and the given integer.
public class FindClosestElementInBST {
	private static int abs(int a){
        return (a<0)?-a:a;
    }
    private static int min(int a,int b){
        return (a<=b)?a:b;
    }
    static int minDiff(BST root, int K) 
    { 
        // Write your code here
        if(root == null) return Integer.MAX_VALUE;
        if(root.left == null && root.right == null) return abs(K-root.val);
        return min(abs(K-root.val),min(minDiff(root.left,K),minDiff(root.right,K)));
    }
}
