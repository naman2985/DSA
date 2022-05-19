package binarySearchTree;

import java.util.ArrayList;
import binaryTree.BinTree;

public class BinaryTreeToBinarySearchTreeConversion {
	static int index;
	static ArrayList<Integer> in;
	static void fillIn(BinTree tree) {
		if(tree != null) {
			if(tree.left != null) fillIn(tree.left);
			in.add(tree.val);
			if(tree.right != null) fillIn(tree.right);
		}
	}
	static void merge(ArrayList<Integer> arr,int start,int mid,int end) {
		int[] a = new int[mid-start+1],b = new int[end-mid];
		for(int i=start,j=0;i<=mid;i++,j++) a[j] = arr.get(i);
		for(int i=mid+1,j=0;i<=end;i++,j++) b[j] = arr.get(i);
		int i=start,j=mid+1,k=start;
		while(i<=mid && j<=end) {
			if(a[i] < b[j]) {
				arr.add(k, a[i]);
				i++;
			}
			else {
				arr.add(k, b[j]);
				j++;
			}
			k++;
		}
		while(i<=mid) {
			arr.add(k,a[i]);
			i++;k++;
		}
		while(j<=end) {
			arr.add(k,b[j]);
			j++;k++;
		}
	}
	static void sort(ArrayList<Integer> arr,int start,int end) {
		if(end > start) {
			sort(arr,start,start + (end-start)/2);
			sort(arr,start + (end-start)/2 + 1,end);
			merge(arr,start,start+(end-start)/2,end);
		}
	}
	static BST convertUtil(BinTree tree,BST bst,Index i) {
		if(tree.left == null) return null;
		BST temp = null;
		if(tree != null) {
			if(tree.left != null) temp = convertUtil(tree.left,bst,i);
			bst = new BST(in.get(i.i++));
			bst.left = temp;
			if(tree.right != null) temp = convertUtil(tree.right,bst,i);
			bst.right = temp;
		}
		return bst;
	}
	static BST convertToBST(BinTree tree) {
		in = new ArrayList<>();
		Index i =  new Index();
		i.i = 0;
		fillIn(tree);
		sort(in,0,in.size()-1);
		BST bst = null;
		convertUtil(tree,bst,i);
		return bst;
	}
	public static void main(String[] args) {
		
	}
}
