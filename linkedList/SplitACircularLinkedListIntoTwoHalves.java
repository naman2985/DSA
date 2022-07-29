package linkedList;

public class SplitACircularLinkedListIntoTwoHalves {
	static Node head1,head2;
	static void splitList(Node list){
        Node mid = list,end = list;
        while(end.next != list){
            end = end.next;
            if(end.next != list){
                mid = mid.next;
                end = end.next;
            }
        }
        end.next = null;
        Node temp = mid.next;
        mid.next = null;
        head1 = list;
        head2 = temp;
    }
	
	public static void main(String[] args) {
		Node list = new Node(0), p = list;
		for(int i=1;i<10;i++) {
			p.next = new Node(i);
			p = p.next;
		}
		p.next = list;
		splitList(list);
		
		Node p1 = head1, p2 = head2;
		while(p1 != null) {
			System.out.print(p1.data + " ");
			p1 = p1.next;
		}
		System.out.println();
		while(p2 != null) {
			System.out.print(p2.data + " ");
			p2 = p2.next;
		}
	}
}
