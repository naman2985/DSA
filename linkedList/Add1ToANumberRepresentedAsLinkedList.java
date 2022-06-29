package linkedList;

class Node{
    int data;
    Node next;
    
    Node(int x){
        data = x;
        next = null;
    }
}

public class Add1ToANumberRepresentedAsLinkedList {
	static Node addedOne(Node head){
        if(head.next == null){
            head.data += 1;
            return head;
        }
        Node next = addedOne(head.next);
        int carry = next.data/10;
        next.data = next.data%10;
        head.data += carry;
        return head;
    }
    public static Node addOne(Node head) 
    { 
        //code here.
        Node list = addedOne(head);
        if(list.data >= 10){
            Node temp = new Node(list.data/10);
            list.data = list.data % 10;
            temp.next = list;
            list = temp;
        }
        return list;
    }
}
