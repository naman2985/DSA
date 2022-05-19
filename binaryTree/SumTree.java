/*
 * Populate a tree such that it contains the sum of the cost of nodes in its left subtree and right subtree.
 * Eg:
 * 			10
 *        /   \
 *      -2      6
 *     /  \    /  \
 *    8   -4  7    5
 *           |
 *           |
 *           |
 *          \ /
 *           v
 *           20
 *         /    \
 *        4     12
 *      /  \   /  \
 *     0    0 0    0
 */

package binaryTree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

class Cost{
	HashMap<BinTree,Integer> sum;
	Cost(HashMap<BinTree,Integer> map){
		sum = map;
	}
}

public class SumTree {
	static Cost cost = new Cost(new HashMap<>());
	static BinTree construct(int arr[]) {
		Queue<BinTree> q = new LinkedList<>();
		if(arr.length == 0) return null;
		BinTree tree = new BinTree(arr[0]);
		q.add(tree);
		int i=1,n=arr.length;
		while(i<n) {
			BinTree temp = q.peek();
			if(temp.left == null) {
				temp.left = new BinTree(arr[i++]);
				q.add(tree.left);
			}
			else {
				temp.right = new BinTree(arr[i++]);
				q.add(tree.right);
				q.poll();
			}
		}
		return tree;
	}
	static int cost(BinTree tree) {
		if(tree.left == null && tree.right == null) {
			cost.sum.put(tree, 0);
			return tree.val;
		}
		else {
			int temp = 0;
			if(tree.left != null) temp += cost(tree.left);
			if(tree.right != null) temp += cost(tree.right);
			cost.sum.put(tree, temp);
		}
		return tree.val + cost.sum.get(tree);
	}
	static BinTree sumTree(BinTree tree) {
		if(tree == null) return null;
		tree.val = cost.sum.get(tree);
		tree.left = sumTree(tree.left);
		tree.right = sumTree(tree.right);
		return tree;
	}
	public static void main(String[] args) {
		int arr[] = {10,-2,6,8,-4,7,5};
		BinTree tree = construct(arr);
		cost(tree);
		BinTree root = sumTree(tree);
		root.inorder();
	}
}
