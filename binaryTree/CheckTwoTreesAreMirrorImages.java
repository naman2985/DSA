package binaryTree;

public class CheckTwoTreesAreMirrorImages {
	static boolean check(BinTree t1,BinTree t2) {
		if(t1 == null && t2 == null) return true;
		if(t1 == null || t2 == null || t1.val != t2.val) return false;
		return check(t1.left,t2.right) && check(t1.right,t2.left);
	}
}
