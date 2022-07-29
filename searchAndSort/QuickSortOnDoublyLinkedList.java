package searchAndSort;

class Node{
	int val;
	Node next;
	Node(int value){
		val = value;
	}
}

public class QuickSortOnDoublyLinkedList {
	public static Node partition(Node l, Node h)
    {
        //code here.
        Node p1 = l,p2 = l;
        while(p1 != h){
            if(p1.val < h.val){
                int temp = p1.val;
                p1.val = p2.val;
                p2.val = temp;
                p2 = p2.next;
            }
            p1 = p1.next;
        }
        int temp = h.val;
        h.val = p2.val;
        p2.val = temp;
        return p2;
    }
}
