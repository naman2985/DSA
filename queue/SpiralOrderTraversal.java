package queue;
import java.util.*;
public class SpiralOrderTraversal {
	static void spiralTraversal(TreeNode tree) {
		Deque<TreeNode> q = new LinkedList<>();
		q.addLast(tree);
		while(!q.isEmpty()) {
			int n = q.size();
			while(n > 0) {
				TreeNode node = q.removeLast();
				System.out.print(node.val + " ");
				if(node.right != null) q.addFirst(node.right);
				if(node.left != null) q.addFirst(node.left);
				n--;
			}
			
			n = q.size();
			while(n > 0) {
				TreeNode node = q.removeFirst();
				System.out.print(node.val + " ");
				if(node.left != null) q.addLast(node.left);
				if(node.right != null) q.addLast(node.right);
				n--;
			}
		}
	}
	
	public static void main(String[] args) {
		TreeNode node = new TreeNode(1);
		node.left = new TreeNode(2);
		node.right = new TreeNode(3);
		TreeNode ptr = node.left;
		ptr.left = new TreeNode(7);
		ptr.right = new TreeNode(6);
		ptr = node.right;
		ptr.left = new TreeNode(5);
		ptr.right = new TreeNode(4);
		spiralTraversal(node);
	}
}
