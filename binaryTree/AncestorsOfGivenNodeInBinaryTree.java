package binaryTree;

import java.util.ArrayList;

public class AncestorsOfGivenNodeInBinaryTree {
	static ArrayList<Integer> arr;
    public static boolean findAncestor(BinTree root,int target){
        if(root == null) return false;
        if(root.val == target) return true;
        if(findAncestor(root.left,target) || findAncestor(root.right,target)){
            arr.add(root.val);
            return true;
        }
        return false;
    }
    public static ArrayList<Integer> Ancestors(BinTree root, int target)
    {
        // add your code here
        arr = new ArrayList<Integer>();
        findAncestor(root,target);
        return arr;
    }
}
