package binaryTree;

class Node{
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}

public class DetermineIfTwoTreesAreIdentical {
	boolean isIdentical(Node root1, Node root2)
	{
	    // Code Here
	    if(root1 != null && root2 != null){
	        if(!isIdentical(root1.left,root2.left)) return false;
	        if(root1.data != root2.data) return false;
	        if(!isIdentical(root1.right,root2.right)) return false;
	    }
	    if(root1 == null ^ root2 == null) return false;
	    return true;
	}
}
