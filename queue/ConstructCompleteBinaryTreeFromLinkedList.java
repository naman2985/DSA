package queue;
import java.util.*;

class TreeNode{
	int val;
	TreeNode left,right;
	TreeNode(int n){
		val = n;
		left = null;
		right = null;
	}
}

public class ConstructCompleteBinaryTreeFromLinkedList {
	/*static TreeNode listToTree(int[] list,int n) {
		int i = 0;
		TreeNode root = null;
		root = addChild(root,list,i,n);
		return root;
	}
	
	static TreeNode addChild(TreeNode root,int[] arr,int i,int n) {
		if(i < n) {
			root = new TreeNode(arr[i]);
			root.left = addChild(root.left,arr,2*i+1,n);
			root.right = addChild(root.right,arr,2*i+2,n);
			return root;
		}
		return null;
	}*/
	
	static TreeNode listToTree(int arr[],int n) {
		Queue<TreeNode> q = new LinkedList<>();
		TreeNode root;
		if(n==0) return null;
		int i=0;
		root = new TreeNode(arr[i++]);
		q.add(root);
		while(i<n) {
			TreeNode parent = q.poll();
			TreeNode l=null,r=null;
			l = new TreeNode(arr[i++]);
			q.add(l);
			if(i<n) {
				r = new TreeNode(arr[i++]);
				q.add(r);
			}
			parent.left = l;
			parent.right = r;
		}
		return root;
	}
	
	public static void inorder(TreeNode tree) {
		if(tree == null) return;
		System.out.println(tree.val);
		inorder(tree.left);
		inorder(tree.right);
	}
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		TreeNode tree = listToTree(arr,5);
		inorder(tree);
	}
}
