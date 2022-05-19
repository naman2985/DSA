package binaryTree;
/*
 * Find the distance between two keys in a binary tree, no parent pointers are given. 
 * The distance between two nodes is the minimum number of edges to be traversed to reach one node from another.
 */
public class DistanceBetweenTwoNodesOfBinaryTree {
	static BinTree lca(BinTree root,int n1,int n2){
        if(root == null) return null;
        if(root.val == n1 || root.val == n2) return root;
        BinTree l = lca(root.left,n1,n2);
        BinTree r = lca(root.right,n1,n2);
        if(l != null && r != null) return root;
        return (l == null)?r:l;
    }
    
    static int dist(BinTree root,int a,int b){
        if(root == null) return 0;
        if(root.val == a || root.val == b) return 1;
        int l = dist(root.left,a,b);
        int r = dist(root.right,a,b);
        if(l>0) return l+1;
        if(r > 0) return r + 1;
        return 0;
    }
    
    static int findDist(BinTree root, int a, int b) {
        // Your code here
        BinTree l = lca(root,a ,b);
        return dist(l.left,a,b) + dist(l.right,a,b);
    }
}
