package binaryTree;
import java.util.*;
public class FoldableBinaryTree {
	static boolean foldable(BinTree t1) {
		BinTree left = t1.left,right = t1.right;
		Queue<BinTree> q1 = new LinkedList<>();
		Queue<BinTree> q2 = new LinkedList<>();
		q1.add(left);
		q2.add(right);
		while(!(q1.isEmpty() || q2.isEmpty())) {
			left = q1.poll();
			right = q2.poll();
			if(left.right == null ^ right.left == null || left.left == null ^ right.right == null) return false;
			if(left.left != null) q1.add(left.left);
			if(left.right != null) q1.add(left.right);
			if(right.right != null) q2.add(right.right);
			if(right.left != null) q2.add(right.left);
		}
		if(q1.isEmpty() && q2.isEmpty()) return true;
		return false;
	}
	public static void main(String[] args) {
		BinTree t1 = new BinTree(1);
		t1.left = new BinTree(2);
		t1.right = new BinTree(3);
		t1.left.left = new BinTree(4);
		t1.right.right = new BinTree(5);
		
		BinTree t2 = new BinTree(1);
		t2.left = new BinTree(2);
		t2.left.right = new BinTree(4);
		t2.right = new BinTree(3);
		t2.right.left = new BinTree(5);
		
		BinTree t3 = new BinTree(1);
		t3.left = new BinTree(2);
		t3.left.left = new BinTree(3);
		t3.right = new BinTree(4);
		t3.right.left = new BinTree(5);
		
		System.out.println(foldable(t1));
		System.out.println(foldable(t2));
		System.out.println(foldable(t3));
	}
}
