package binarySearchTree;

public class CountBSTNodesInGivenRange {
	private static int inRange(BST root,int l,int h){
        return (root.val <= h && root.val >= l)?1:0;
    }
    static int getCount(BST root,int l, int h)
    {
        //Your code here
        if(root == null) return 0;
        return getCount(root.left,l,h) + getCount(root.right,l,h) + inRange(root,l,h);
    }
}
