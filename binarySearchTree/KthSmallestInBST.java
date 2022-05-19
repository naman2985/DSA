package binarySearchTree;

public class KthSmallestInBST {
	int i=0;
	int kthSmallest(BST root,int K) {
		if(root == null) return -1;
		int left = kthSmallest(root.left,K);
		if(left != -1) return left;
		i++;
        if(i == K) return root.val;
		int right = kthSmallest(root.right,K);
		return right;
	}
}
