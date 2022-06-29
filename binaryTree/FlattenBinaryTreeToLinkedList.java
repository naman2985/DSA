package binaryTree;

public class FlattenBinaryTreeToLinkedList {
	static Node lastNode;
    public static void flatten(Node root)
    {
        //code here
        if(root != null){
            if(root.left == null && root.right == null){
                lastNode = root;
                return;
            }
            if(root.left != null){
                flatten(root.left);
                lastNode.right = root.right;
                root.right = root.left;
                root.left = null;
            }
            else lastNode = root;
            flatten(lastNode.right);
        }
    }
}
