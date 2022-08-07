package linkedList;

public class MergeSortDoublyLinkedList {
	static class Node
	{
	    int data;
	    Node next, prev;
	    Node(int data)
	    {
	        this.data = data;
	        next = prev = null;
	    }
	}
	
	static Node sortDoubly(Node head)
    {
        // add your code here
        if(head != null && head.next != null){
            Node slow = head, fast = head;
            while(fast.next != null && fast.next.next != null){
                fast = fast.next.next;
                slow = slow.next;
            }
            slow = slow.next;
            slow.prev.next = null;
            slow.prev = null;
            head = sortDoubly(head);
            Node tail = sortDoubly(slow);
            fast = head;
            while(fast.next != null) fast = fast.next;
            fast.next = tail;
            tail.prev = fast;
            fast = new Node(0);
            Node p1 = head, p2 = tail;
            head = fast;
            while(p1 != tail && p2 != null){
                if(p1.data <= p2.data){
                    fast.data = p1.data;
                    p1 = p1.next;
                }
                else{
                    fast.data = p2.data;
                    p2 = p2.next;
                }
                fast.next = new Node(0);
                fast.next.prev = fast;
                fast = fast.next;
            }
            while(p1 != tail){
                fast.data = p1.data;
                fast.next = new Node(0);
                fast.next.prev = fast;
                fast = fast.next;
                p1 = p1.next;
            }
            while(p2 != null){
                fast.data = p2.data;
                fast.next = new Node(0);
                fast.next.prev = fast;
                fast = fast.next;
                p2 = p2.next;
            }
            fast.prev.next = null;
            fast = fast.prev;
        }
        return head;
    }
}
