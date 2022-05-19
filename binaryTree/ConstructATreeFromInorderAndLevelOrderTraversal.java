package binaryTree;
import java.util.*;
public class ConstructATreeFromInorderAndLevelOrderTraversal {
	static BinTree buildTree(int in[],HashMap<Integer,Integer> map,int start,int end) {
		if(start > end) return null;
		int min_id = start;
		for(int i=start + 1;i<=end;i++) {
			if(map.get(in[min_id])>map.get(in[i])) {
				min_id = i;
			}
		}
		BinTree root = new BinTree(in[min_id]);
		if(start == end) return root;
		root.left = buildTree(in, map, start, min_id-1);
		root.right = buildTree(in, map, min_id+1, end);
		return root;
	}
	public static void main(String[] args) {
		int in[] = {7,4,2,5,8,1,3,9,6,10}, bfs[] = {1,2,3,4,5,6,7,8,9,10};
		int n = in.length;
		HashMap<Integer,Integer> map = new HashMap<>();
		for(int i=0;i<n;i++) {
			map.put(bfs[i], i);
		}
		BinTree tree = buildTree(in,map,0,n-1);
		tree.inorder();
	}
}

/*
 *         1
 *       /   \
 *      2     3
 *     / \     \
 *    4   5     6
 *   /     \   / \
 *  7       8 9   10
 * 
 */
