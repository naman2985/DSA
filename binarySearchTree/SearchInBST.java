package binarySearchTree;

public class SearchInBST {
	static BST search(BST root,int val) {
		if(root == null) return null;
	    if(root.val == val) return root;
	    else if(root.val > val) return search(root.left,val);
	    return search(root.right,val);
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
		
		System.out.print(search(tree,40).val);
	}
}
