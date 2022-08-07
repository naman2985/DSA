package searchAndSort;

public class QuickSortLinkedList {
	private static class Node{
	    int data;
	    Node next;
	    Node(int key)
	    {
	        data = key;
	        next = null;
	    }
	    
	}
	
	static Node partition(Node node){
        Node i = node.next, j=node, prev = null;
        while(i != null){
            if(i.data <= node.data){
                prev = j;
                j = j.next;
                int temp = i.data;
                i.data = j.data;
                j.data = temp;
            }
            i = i.next;
        }
        int temp = node.data;
        node.data = j.data;
        j.data = temp;
        if(prev != null)
            prev.next = null;
        return j;
    }
    public static Node quickSort(Node node)
    {
        //Your code here
        if(node != null && node.next != null){
            Node p = partition(node);
            Node head = node;
            if(p != node) head = quickSort(node);
            Node tail = quickSort(p.next);
            p.next = null;
            Node last = head;
            while(last.next != null) last = last.next;
            if(last != null) last.next = p;
            p.next = tail;
            node = head;
        }
        return node;
    }
    public static void main(String[] args) {
		Node node = new Node(4);
		node.next = new Node(2);
		node.next.next = new Node(3);
		node.next.next.next = new Node(1);
		Node result = quickSort(node);
		for(node = result;node != null;node = node.next) {
			System.out.print(node.data + " ");
		}
	}
}
