package binaryTree;
//import java.util.*;
class Index{
	int id;
}
public class SpecialTreeFromPreOrder {
	static Index index = new Index();
	static BinTree construct(int pre[],char preLN[],int n,Index index) {
		int i = index.id;
		if(i >= n) return null;
		BinTree tree = new BinTree(pre[i]);
		index.id++;
		if(preLN[i] == 'N') {
			tree.left = construct(pre,preLN,n,index);
			tree.right = construct(pre,preLN,n,index);
		}
		return tree;
	}
	
	static BinTree constructSpecialTree(int pre[],char[] preLN) {
		/*Queue<BinTree> q = new LinkedList<>();
		int n = pre.length;
		if(n == 0) return null;
		BinTree tree = new BinTree(pre[0]);
		q.add(tree);
		for(int i=1;i<n;i++) {
			BinTree temp = q.poll();
			temp.left = new BinTree(pre[i]);
			if(preLN[i] == 'N') q.add(temp.left);
			i++;
			if(i == n) break;
			temp.right = new BinTree(pre[i]);
			if(preLN[i] == 'N') q.add(temp.right);
		}
		return tree;*/
		index.id = 0;
		return construct(pre,preLN,pre.length,index);
	}
	public static void main(String[] args) {
		int pre[] = {10, 30, 20, 5, 25};
		char preLN[] = {'N', 'N', 'L', 'L', 'L'};
		BinTree tree = constructSpecialTree(pre,preLN);
		tree.inorder();
		/*
		 *        10
		 *      /    \
		 *     30     20
		 *    /  \
		 *   5    15
		 *   
		 *   5 30 15 10 20
		 */
	}
}
