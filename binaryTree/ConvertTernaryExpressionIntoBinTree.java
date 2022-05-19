/*
 * Given a binary expression in form of a string. Convert the expression into a binary tree.
 * Eg: a?b:c ->  a
 *              / \
 *             b   c
 * 
 * a?b?c:d:e -> a
 *            /   \
 *           b     e
 *          / \
 *         c   d
 */

package binaryTree;
class BinTree2{
	char val;
	BinTree2 left,right;
	BinTree2(char a){
		val = a;
		left = null;
		right = null;
	}
	void inorder() {
		if(this.left != null) this.left.inorder();
		System.out.print(this.val + " ");
		if(this.right != null) this.right.inorder();
	}
}
class Idx{
	int i;
}
public class ConvertTernaryExpressionIntoBinTree {
	static Idx index = new Idx();
	static BinTree2 convert(String ter,Idx id) {
		if(id.i >= ter.length()) return null;
		BinTree2 tree = new BinTree2(ter.charAt(id.i));
		++id.i;
		if(id.i<ter.length()) {
			if(ter.charAt(id.i) == '?') {
				id.i++;
				tree.left = convert(ter,id);
				id.i++;
				tree.right = convert(ter,id);
			}
		}
		return tree;
	}
	public static void main(String[] args) {
		String ter = "a?b?c:d:e";
		index.i = 0;
		convert(ter,index).inorder();
	}
}
