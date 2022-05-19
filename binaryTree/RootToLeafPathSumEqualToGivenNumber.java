package binaryTree;

public class RootToLeafPathSumEqualToGivenNumber {
	static boolean checkPath(BinTree root,int S,int sum){
        if(root == null) return false;
        sum += root.val;
        if(sum == S && root.left == null && root.right == null) return true;
        if(sum > S) return false;
        if(checkPath(root.left,S,sum) || checkPath(root.right, S,sum)) return true;
        return false;
    }
    boolean hasPathSum(BinTree root, int S) {
        return checkPath(root,S,0);
    }
}
