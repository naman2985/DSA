package binarySearchTree;

public class InorderSuccessorOfANode {
	boolean next = false;
	public BST inorderSuccessor(BST root,BST x)
    {
        if(root == null) return null;
        BST left = inorderSuccessor(root.left,x);
        if(left != null) return left;
        if(next) return root;
        if(root == x) next = true;
        BST right = inorderSuccessor(root.right,x);
        return right;
    }
}
