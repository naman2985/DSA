package binaryTree;

import java.util.ArrayList;
//import java.util.HashMap;

/*
 * A binary tree and a number k are given. Print every path in the tree with sum of the nodes in the path as k. 
 * A path can start from any node and end at any node and must be downward only, i.e. they need not be root node and leaf node; 
 * and negative numbers can also be there in the tree.
 * 
 */
public class KSumPathsInABinaryTree {
	static ArrayList<Integer> arr;
	static void print(ArrayList<Integer> arr,int index) {
		int n = arr.size();
		for(int i=index;i<n;i++) {
			System.out.print(arr.get(i) + " ");
		}
		System.out.println();
	}
	static void checkPath(BinTree tree,int k) {
		if(tree == null) return;
		arr.add(tree.val);
		checkPath(tree.left,k);
		checkPath(tree.right,k);
		int sum = 0;
		for(int i=arr.size()-1;i>=0;i--) {
			sum += arr.get(i);
			if(sum == k)
				print(arr,i);
		}
		arr.remove(arr.size()-1);
	}
	static void printPath(BinTree tree,int k) {
		//HashMap<BinTree,Integer> sum = new HashMap<>();
		arr = new ArrayList<>();
		checkPath(tree,k);
	}
}
