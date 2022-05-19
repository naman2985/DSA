package binarySearchTree;

import java.util.ArrayList;

public class PrintElementsInGivenRange {
	private static ArrayList<Integer> arr;
    private static ArrayList<Integer> util(BST root,int low,int high){
        if(root == null) return null;
        util(root.left,low,high);
        if(root.val <= high && root.val >= low) arr.add(root.val);
        util(root.right,low,high);
        return arr;
    }
	public static ArrayList<Integer> printNearNodes(BST root,int low,int high) {
        // code here.
        arr = new ArrayList<>();
        return util(root,low,high);
    }
}
