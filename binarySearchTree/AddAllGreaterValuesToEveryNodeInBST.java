package binarySearchTree;

public class AddAllGreaterValuesToEveryNodeInBST {
	static int greater;
    BST modifyUtil(BST root){
        if(root == null) return null;
        root.right = modifyUtil(root.right);
        int temp = root.val;
        root.val += greater;
        greater += temp;
        root.left = modifyUtil(root.left);
        return root;
    }
    public BST modify(BST root)
    {
        //Write your code here
        greater=0;
        root = modifyUtil(root);
        return root;
    }
}
