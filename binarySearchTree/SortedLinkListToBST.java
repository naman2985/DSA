package binarySearchTree;

import linkedList.LinkedList;

public class SortedLinkListToBST {
	static BST convertToTree(LinkedList<Integer> start,LinkedList<Integer> end){
        if(end == null) return null;
        if(start == end) return new BST(start.val);
        if(start.next == end){
        	BST temp = new BST(end.val);
            temp.left = new BST(start.val);
            return temp;
        }
        LinkedList<Integer> fast = start,slow = start,prev = null;
        while(fast != end){
            fast = fast.next;
            prev = slow;
            slow = slow.next;
            if(fast != end) fast = fast.next;
        }
        
        BST tree = new BST(slow.val);
        tree.left = convertToTree(start,prev);
        tree.right = convertToTree(slow.next,end);
        return tree;
    }
    public static BST sortedListToBST(LinkedList<Integer> head)
    {
        //code here
    	LinkedList<Integer> temp = head;
        while(temp.next != null) temp = temp.next;
        return convertToTree(head,temp);
    }
}
