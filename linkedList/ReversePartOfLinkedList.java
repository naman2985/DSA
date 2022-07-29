package linkedList;
// leetcode # 92
public class ReversePartOfLinkedList {
	static LinkedList reverseBetween(LinkedList head, int left, int right) {
        int i=1;
        LinkedList ptr=head,prev=null,next=null;
        LinkedList start=null, last=null; 
        while(i < left){
            prev = ptr;
            ptr = ptr.next;
            i++;
        }
        last = prev;
        start = ptr;
        next = ptr;
        while(i <= right){
            ptr = next;
            next = next.next;
            ptr.next = prev;
            prev = ptr;
            i++;
        }
        if(last != null) last.next = ptr;
        start.next = next;
        return (left == 1)?ptr:head;
    }
}
