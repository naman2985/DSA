package binarySearchTree;

public class KthLargestInBST {
	int i;
	int kthLargest(BST root,int K) {
		if(root == null) return -1;
        int right = kthLargest(root.right,K);
        if(right != -1) return right;
        i++;
        if(i == K) return root.val;
        int left = kthLargest(root.left,K);
        return left;
	}
	int kthLargestElement(BST root,int K) {
		i = 0;
		return kthLargest(root,K);
	}
}
