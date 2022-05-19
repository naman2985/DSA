/*
 * Converting the tree to a linked list or array is known as Serialisation
 * Converting it back to a tree is called De-serialisation
 * For null values we insert a special symbol (here, $) and # marks the end of the tree
 */

package binaryTree;
import java.util.LinkedList;
import java.util.Queue;
public class SerialisationAndDeserialisation {
	public static String serialise(BinTree tree,String ser) {
		Queue<BinTree> s = new LinkedList<>();
		s.add(tree);
		while(!s.isEmpty()) {
			BinTree temp = s.poll();
			if(temp == null) {
				ser += "$";
			}
			else {
				ser += String.valueOf(temp.val);
				if(temp.left != null || temp.right != null) {
					s.add(temp.left);
					s.add(temp.right);
				}
			}
		}
		return ser;
	}
	public static BinTree deserialise(String ser) {
		BinTree tree = new BinTree(ser.charAt(0)-'0');
		Queue<BinTree> q = new LinkedList<>();
		q.add(tree);
		int n = ser.length();
		for(int i=1;i<n;i++) {
			if(ser.charAt(i) != '$') {
				BinTree temp = q.poll();
				temp.left = new BinTree(ser.charAt(i)-'0');
				q.add(temp.left);
				if(++i < n && ser.charAt(i) != '$') {
					temp.right = new BinTree(ser.charAt(i)-'0');
					q.add(temp.right);
				}
			}
		}
		return tree;
	}
	public static void main(String[] args) {
		String s = "1234$$567$$";
		BinTree t = deserialise(s);
		t.inorder();
		
		BinTree tree = new BinTree(1);
		tree.left = new BinTree(2);
		tree.right = new BinTree(3);
		tree.left.left = new BinTree(5);
		tree.left.right = new BinTree(6);
		tree.right.left = new BinTree(7);
		tree.right.right = new BinTree(2);
		tree.right.right.left = new BinTree(5);
		tree.right.right.right = new BinTree(6);
		System.out.println(serialise(tree,""));
		System.out.println(serialise(t,""));
	}
}
