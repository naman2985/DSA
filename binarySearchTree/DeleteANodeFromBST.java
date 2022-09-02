package binarySearchTree;

public class DeleteANodeFromBST {
	public static Node deleteCurrentNode(Node root){
        if(root.left == null && root.right == null) return null;
        else if(root.right == null) return root.left;
        else if(root.left == null) return root.right;
        Node ptr = root.right;
        while(ptr.left != null) ptr = ptr.left;
        root.data = ptr.data;
        ptr = root.right;
        if(ptr.data == root.data) root.right = ptr.right;
        else{
            while(ptr.left.data != root.data) ptr = ptr.left;
            ptr.left = null;
        }
        return root;
    }
    
    public static Node deleteNode(Node root, int x) {
        // code here.
        if(root == null) return null;
        if(x < root.data){
            root.left = deleteNode(root.left,x);
        }
        else if(root.data == x){
            root = deleteCurrentNode(root);
        }
        else{
            root.right = deleteNode(root.right, x);
        }
        return root;
    }
}
