package binaryTree;

public class BinTree {
	public int val;
	public BinTree left,right;
	BinTree(int v){
		val = v;
		left = null;
		right = null;
	}
	public void inorder() {
		if(this.left != null) this.left.inorder();
		System.out.print(this.val+" ");
		if(this.right != null) this.right.inorder();
	}
}
