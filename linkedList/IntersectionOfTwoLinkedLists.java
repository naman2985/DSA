package linkedList;
// leetcode 160
class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
        next = null;
    }
}

public class IntersectionOfTwoLinkedLists {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode h1,h2;
        int n1=0,n2=0;
        for(h1=headA;h1!=null;){
            n1++;
            h1=h1.next;
        }
        for(h2=headB;h2!=null;){
            n2++;
            h2=h2.next;
        }
        h1=headA;
        h2=headB;
        for(int i=0;i<n1-n2;i++){
            h1=h1.next;
        }
        for(int j=0;j<n2-n1;j++){
            h2=h2.next;
        }
        while(h1!=null && h2!=null){
            if(h1==h2) return h1;
            h1=h1.next;
            h2=h2.next;
        }
        return null;
    }
}
