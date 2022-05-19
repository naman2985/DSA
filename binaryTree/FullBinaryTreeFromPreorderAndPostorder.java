/*
 * Full Binary tree : tree which has either 0 or 2 children for every node
 */


package binaryTree;
import java.util.*;
public class FullBinaryTreeFromPreorderAndPostorder {
	static HashMap<Integer,Integer> map;
	static int id = 0;
	static BinTree construct(int pre[],int post[],int l,int h,int n) {
		if(l>h || id>=n) return null;
		BinTree tree = new BinTree(pre[id++]);
		if(l==h || id>=n) return tree;
		int i = map.get(pre[id]);
		if(i<=h) {
			tree.left = construct(pre,post,l,i,n);
			tree.right = construct(pre,post,i+1,h-1,n);
		}
		return tree;
	}
	static BinTree buildTree(int pre[],int post[]) {
		return construct(pre,post,0,pre.length-1,pre.length);
	}
	public static void main(String[] args) {
		int pre[] = {1,2,4,8,9,5,3,6,7},post[] = {8,9,4,5,2,6,7,3,1};
		map = new HashMap<>();
		for(int i=0;i<post.length;i++) {
			map.put(post[i],i);
		}
		BinTree tree = buildTree(pre,post);
		tree.inorder();
		/*
		 *          1
		 *        /   \
		 *       2     3
		 *      / \   / \
		 *     4   5 6   7
		 *    / \
		 *   8   9
		 *  
		 */
	}
}
