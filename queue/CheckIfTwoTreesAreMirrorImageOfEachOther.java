package queue;
import java.util.*;
class NAryTree{
	int val;
	Vector<NAryTree> child;
	private int size = 0;
	NAryTree(int n){
		val = n;
		child = new Vector<>();
	}
	void add(NAryTree n) {
		child.add(n);
		size++;
	}
	int getSize() {
		return size;
	}
	NAryTree next(int i) {
		return child.elementAt(i);
	}
}
public class CheckIfTwoTreesAreMirrorImageOfEachOther {
	static boolean areMirrorImage(NAryTree t1,NAryTree t2) {
		NAryTree p1,p2;
		Queue<NAryTree> q1 = new LinkedList<>();
		Queue<NAryTree> q2 = new LinkedList<>();
		q1.add(t1);q2.add(t2);
		while(!q1.isEmpty() || !q2.isEmpty()) {
			p1 = q1.poll();
			p2 = q2.poll();
			if(p1.val!=p2.val) return false;
			int n= p1.getSize();
			if(n != p2.getSize()) return false;
			for(int i=0;i<n;i++) {
				q1.add(p1.next(i));
			}
			for(int i=n-1;i>=0;i--) {
				q2.add(p2.next(i));
			}
		}
		return true;
	}
	public static void main(String[] args) {
		NAryTree t1 = new NAryTree(1);
		t1.add(new NAryTree(2));
		t1.add(new NAryTree(3));
		NAryTree t2 = new NAryTree(1);
		t2.add(new NAryTree(2));
		t2.add(new NAryTree(3));
		NAryTree t3 = new NAryTree(1);
		t3.add(new NAryTree(3));
		t3.add(new NAryTree(2));
		System.out.println(areMirrorImage(t1,t2));
		System.out.println(areMirrorImage(t1,t3));
	}
}
