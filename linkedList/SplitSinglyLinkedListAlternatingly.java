package linkedList;

public class SplitSinglyLinkedListAlternatingly {
	static Node a,b;
	public static void alternatingSplitList(Node head){
		a = new Node(0);
		b = new Node(0);
		Node p1 = a, p2 = b;
        Node ptr = head;
        boolean alt = false;
        while(ptr != null){
        	Node temp = ptr.next;
            ptr.next = null;
            if(!alt){
            	p1.next = ptr;
                p1 = p1.next;
            }
            else{
                p2.next = ptr;
                p2 = p2.next;
            }
            alt = !alt;
            ptr = temp;
        }
        a = a.next;
        b = b.next;
    }
}
