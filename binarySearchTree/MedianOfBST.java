package binarySearchTree;

public class MedianOfBST {
	static int count(BST root) {
		if(root == null) return 0;
		BST current=root,pre;
		int count = 0;
		while(current != null) {
			if(current.left == null) {
				count++;
				current = current.right;
			}
			else {
				pre = current.left;
				while(pre.right != null && pre.right != current) {
					pre = pre.right;
				}
				if(pre.right == null) {
					pre.right = current;
					current = pre.left;
				}
				else {
					pre.right = null;
					count++;
					current = current.right;
				}
			}
		}
		return count;
	}
	static int findMedian(BST root) {
		if(root == null) return 0;
		int c = count(root);
		int curr = 0;
		BST current = root,pre = null, prev = null;
		while(current != null) {
			if(current.left == null) {
				curr++;
				if(c % 2 != 0 && curr == (c+1)/2) return prev.val;
				else if(c % 2 == 0 && curr == c/2 + 1) return (prev.val + current.val)/2;
				prev = current;
				current = current.right;
			}
			else {
				pre = current.left;
				while(pre.right != null && pre.right != current) pre = pre.right;
				if(pre.right == null) {
					pre.right = current;
					current = current.left;
				}
				else {
					pre.right = null;
					prev = pre;
					curr++;
					if(c % 2 != 0 && curr == (c+1)/2) return current.val;
					else if(c % 2 == 0 && curr == (c/2)+1) return (current.val + prev.val)/2;
					prev = current;
					current = current.right;
				}
			}
		}
		return -1;
	}
}
