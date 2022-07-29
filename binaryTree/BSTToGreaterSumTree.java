package binaryTree;

//Given a BST, transform it into greater sum tree where each node contains sum of all nodes greater than that node.

public class BSTToGreaterSumTree {
	static int sum;
    private static void addSum(Node root){
        if(root != null){
            addSum(root.right);
            sum += root.data;
            root.data = sum-root.data;
            addSum(root.left);
        }
    }
    
    public static void transformTree (Node root)
    {
        //code here
        sum = 0;
        addSum(root);
    }
}
