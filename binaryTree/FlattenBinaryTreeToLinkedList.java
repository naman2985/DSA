package binaryTree;

public class FlattenBinaryTreeToLinkedList {
	static Node lastNode;
    public static void flatten(Node root)
    {
        //code here
    	if(root != null){
            lastNode = root;
            flatten(root.left);
            Node right = root.right;
            root.right = root.left;
            root.left = null;
            lastNode.right = right;
            flatten(right);
        }
    }
}
