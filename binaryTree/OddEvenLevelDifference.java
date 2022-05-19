package binaryTree;
/*
 * Given a a Binary Tree, find the difference between the sum of nodes at odd level and the sum of nodes at even level. 
 * Consider root as level 1, left and right children of root as level 2 and so on.
 */
public class OddEvenLevelDifference {
	static int maxDiff(BinTree root,boolean ev){
        if(root == null) return 0;
        return root.val - (maxDiff(root.left,!ev) + maxDiff(root.right,!ev));
    }
	static int getLevelDiff(BinTree root)
	{
	    return maxDiff(root,false);
	}
}
