package binaryTree;

class Size{
	public int val;
}
public class DensityOfBinaryTree {
	static int heightAndSize(BinTree tree,Size size) {
		if(tree == null) return 0;
		int l = heightAndSize(tree.left,size);
		int r = heightAndSize(tree.right,size);
		size.val++;
		return (l>r)?l+1:r+1;
	}
	static double density(BinTree tree) {
		Size size = new Size();
		size.val = 0;
		if(tree == null) return 0;
		int ht = heightAndSize(tree,size);
		return (double) size.val/ht;
	}
	public static void main(String[] args) {
		BinTree tree = new BinTree(1);
		tree.left = new BinTree(2);
		tree.right = new BinTree(3);
		tree.left.right = new BinTree(4);
		tree.right.left = new BinTree(5);
		tree.right.right = new BinTree(6);
		
		System.out.println(density(tree));
	}
}
