package binaryTree;

public class PrintNodesAtOddLevel {
	static void printUtil(BinTree tree,boolean print) {
		if(tree != null) {
			printUtil(tree.left,!print);
			if(print) System.out.print(tree.val+ " ");
			printUtil(tree.right,!print);
		}
	}
	static void printOdd(BinTree tree) {
		printUtil(tree,true);
	}
}
