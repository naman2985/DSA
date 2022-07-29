package linkedList;

public class MergeSortForLinkedList {
	static Node merge(Node head,Node next){
        Node a = head,b = next,result=new Node(0),ptr;
        ptr = result;
        while(a != null && b != null){
            if(a.data <= b.data){
                ptr.next = a;
                a = a.next;
            }
            else{
                ptr.next = b;
                b = b.next;
            }
            ptr = ptr.next;
            ptr.next = null;
        }
        while(a != null) {
            ptr.next = a;
            a = a.next;
            ptr = ptr.next;
            ptr.next = null;
        }
        while(b!= null){
            ptr.next = b;
            b = b.next;
            ptr = ptr.next;
            ptr.next = null;
        }
        return result.next;
    }
    
    static Node mergeSortRec(Node head){
        if(head != null && head.next != null){
            Node slow=head,fast=head;
            while(fast.next != null){
                fast = fast.next;
                if(fast.next != null){
                    slow = slow.next;
                    fast = fast.next;
                }
            }
            Node temp=slow.next;
            slow.next=null;
            head = mergeSortRec(head);
            temp = mergeSortRec(temp);
            return merge(head,temp);
        }
        return head;
    }
    
    static Node mergeSort(Node head)
    {
        // add your code here
        return mergeSortRec(head);
    }
}
