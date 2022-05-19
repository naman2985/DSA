package queue;
import java.util.*;

public class CheckIfABinaryTreeIsComplete {
	//TreeNode declared in class ConstructCompleteBinaryTreeFromLinkedList
	static boolean isComplete(TreeNode tree) {
		Queue<TreeNode> q = new LinkedList<>();
		if(tree!=null) q.add(tree);
		while(!q.isEmpty()) {
			TreeNode node = q.poll();
			if(node.left == null) {
				if(node.right != null) return false;
				return check(q);
			}
			else if(node.right == null) {
				q.add(node.left);
				return check(q);
			}
			else {
				q.add(node.left);
				q.add(node.right);
			}
		}
		return true;
	}
	
	static boolean check(Queue<TreeNode> q) {
		while(!q.isEmpty()) {
			TreeNode node = q.poll();
			if(node.left != null || node.right != null) return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		TreeNode tree1 = new TreeNode(0);
		tree1.left = new TreeNode(1);
		tree1.right = new TreeNode(2);
		tree1.left.left = new TreeNode(3);
		System.out.println(isComplete(tree1));
		
		TreeNode tree2 = new TreeNode(0);
		tree2.left = new TreeNode(1);
		tree2.right = new TreeNode(2);
		tree2.right.left = new TreeNode(3);
		System.out.println(isComplete(tree2));
	}
}
