package binarySearchTree;

public class BST {
	int val;
	BST left;
	BST right;
	BST(int data){
		val = data;
	}
	void insert(int data) {
		if(data < this.val) {
			if(left == null) left = new BST(data);
			else left.insert(data);
		}
		else {
			if(right == null) right = new BST(data);
			else right.insert(data);
		}
	}
	void delete(int data) {
		
	}
	void inorder() {
		if(this != null) {
			if(left != null) left.inorder();
			System.out.print(val+" ");
			if(right != null) right.inorder();
		}
	}
	public static void main(String[] args) {
		BST tree = new BST(50);
		tree.insert(10);
		tree.insert(30);
		tree.insert(70);
		tree.insert(60);
		tree.insert(40);
		tree.insert(90);
		tree.insert(25);
		tree.inorder();
		/*
		 * 				50
		 *           /     \
		 *          10      70
		 *            \     / \
		 *            30   60  90
		 *           / \
		 *          25 40
		 * 
		 * 10 25 30 40 50 60 70 90
		 */
	}
}
