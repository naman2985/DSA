package binarySearchTree;

public class SumOfKSmallestElements {
	int s=0,n=0;
    int sum(BST root, int k) { 
        // Code here
        if(k == n || root == null) return s;
        sum(root.left,k);
        if(n<k){
            s += root.val;
            n++;
        }
        sum(root.right,k);
        return s;
    }
}
